package model.familyTree;

import model.human.Gender;
import model.human.comparators.HumanComparatorByGender;
import model.human.comparators.HumanComparatorByName;
import model.human.comparators.HumansComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> familyTree;
    private long humansId;

//    public model.familyTree.FamilyTree(List<model.human.Human> humans) {
//        this.humans = humans;
//    }

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    /**
     * Метод принимает человека и если такого человека еще нет в списке, добавляет его в список
     * так же добавляет его к родителям(если они есть) и к детям (если они есть)
     * @param human - человек
     */
    public void addTreeItem(E human) {
        if (human != null && !familyTree.contains(human)) {
            familyTree.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
        } else System.out.println("Ошибка");
    }

    /**
     * Принимает человека и добавляет его в качестве ребенка родителям (если они есть),
     * если родителя нет то цикл продолжается без добавления ему ребенка
     * @param human
     */
    private void addToParents(E human) {
        List<E> parents = new ArrayList<>();
        parents.add((E) human.getMother());
        parents.add((E) human.getFather());
        for (E parent : parents){
            if (parent == null)
                continue;
            parent.addChild(human);
        }
    }

    /**
     * принимает человека и добавляет его в качестве родителя ребенку (если они есть),
     *
     * @param human
     */

    private void addToChildren(E human) {
        for (E child :  human.getChildren()) {
            if (human.getGender() == Gender.MALE)
                child.setFather(human);
            else child.setMother(human);
        }
    }

    /**
     * принимает id человека, с помощью метода getById ищет этого человека из списка,
     * перебирая детей родителей, возвращает список братьев и сестер человека
     * @param id
     * @return
     */
    private List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null)
            return null;
        List<E> res = new ArrayList<>();
        List<E> parents =  new ArrayList<>(List.of(human.getMother(),
                 human.getFather()));
        for (E parent : parents){
            for (E child :  parent.getChildren()){
                if(!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }


    /**
     * поиск по имени
     * @param name
     * @return
     */
    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human : familyTree){
            if (human.getName().equalsIgnoreCase(name))
                res.add(human);
        }
        return res;
    }

    public E getById(long id){
        for (E human: familyTree){
            if (human.getId()==id){
                return human;
            }
        }
        return null;
    }

    /**
     * принимает 2 id, с помощью метода getById инициализируем 2 объекта model.human.Human,
     * далее передаем их в перегруженный метод setWedding(model.human.Human, model.human.Human)
     * @param humanId1
     * @param humanId2
     * @return
     */
    public boolean setWedding (long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    /**
     * принимает 2 объекта model.human.Human, методом .getSpouse проверяет нет ли у объектов супругов(Spouse)
     * если супругов нет, методом setSpouse устанавливает им супргов(друг друга)
     * @param human1
     * @param human2
     * @return
     */
    public boolean setWedding(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    /**
     * принимает 2 id, с помощью метода getById инициализируем 2 объекта model.human.Human,
     * далее передаем их в перегруженный метод setDivorce(model.human.Human, model.human.Human)
     * @param humanId1
     * @param humanId2
     * @return
     */
    public boolean setDivorce(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    /**
     * принимает 2 объекта model.human.Human, методом .getSpouse проверяет являются ли объекты супругами(Spouse)
     * друг друга, методом setSpouse устанавливает им супргов(null - отсутсвует)
     * @param human1
     * @param human2
     * @return
     */
    public boolean setDivorce(E human1, E human2){
        if(human1.getSpouse() == human2 && human2.getSpouse() == human1){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    /**
     * метод удаления объекта из списка с помощью поиска  по id
     * @param humanId
     * @return
     */
    public boolean remove(long humanId){
        if (checkId(humanId)){
            E human = getById(humanId);
            return familyTree.remove(human);
        }
        return false;
    }

    /**
     * проверка id (валидация)
     * @param id
     * @return
     */
    private boolean checkId(long id){
        if (id >= humansId || id < 0)
            return false;
        for (E human : familyTree){
            if (human.getId() == id)
                return true;
        }
        return false;
    }

    /**
     * поиск по id
     * @param id
     * @return
     */




    /**
     * Метод возвращающий Коллекцию типа List
     */
    public List<E> getFamilyTree() {
        return familyTree;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(this.familyTree);
    }


    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new HumansComparatorByAge<>());
    }

    public void sortByGender(){
        familyTree.sort(new HumanComparatorByGender<>());
    }
}
