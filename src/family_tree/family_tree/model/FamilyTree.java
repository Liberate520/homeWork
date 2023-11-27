package family_tree.family_tree.model;

import family_tree.family_tree.model.human.Human;
import family_tree.family_tree.model.human.comparators.ComparatorByName;
import family_tree.family_tree.model.human.comparators.ComporatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<G extends GeneralTypeTree<G>> implements Serializable, Iterable<Human> {
    private long humansId; //генерация идентификаторов для присваивания человекам
    private List<Human> humanList;  //список людей
    public FamilyTree() {
        this(new ArrayList<>()); }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList; }
    public boolean add(Human human){   // метод добавления в семью нового человека
        if (human == null){    //проверка на наличие пустой ссылки
            return false;
        }
        if (!humanList.contains(human)){   //проверка что еще такого человека нет в нашей семье
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);    // методы создающие связи(обратные) с членами семьи
            addToChildren(human);

            return true;
        }
        return false;
    }
// метод позволяющий найти Human-a по идентификатору
    public Human getById(long id){
        if (!checkId(id)){
            return null;
        }
        for (Human human : humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }
// метод поиска братьев и сестер
    public List<Human> getSiblings(int id) { //пеередается идентификатор человека и возвр список детей
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){

                }
            }
        }
        return res;
    }
// метод поиска по имени
    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }
//метод создающий супружеские связи
    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1); //работа с идентификаторами
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }
    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2); // работа с именами
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }
// метод развода
    public boolean setDivorse(long eId1, long eId2){
        if (checkId(eId1) && checkId(eId2)) {
            Human e1 = getById(eId1);
            Human e2 = getById(eId2);
            return setDivorse(e1, e2);
        }
        return false;
    }
    public boolean setDivorse(Human e1, Human e2){
        if (e1.getSpouse() != null && e2.getSpouse() != null){
            e1.setSpouse(null);
            e2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }
//удаление из семейного дерева (случайно добавили, или по ошибке)
    public boolean remove(long eId){
        if (checkId(eId)){
            Human human = getById(eId);
            return humanList.remove(human);
        }
        return false;
    }
// создание родственных связей в обе стороны
    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human); // у родителей появился новый ребенок
        }
    }
    private void addToChildren(Human human){
        for (Human child : human.getChildren()){
            child.addParent(human); // ребенку сообщаем что у него есть родители
        }
    }
    // метод предварительной проверки идентификатора в нужном диапазоне
    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }
// метод возвращающий информацию по всем дереву (перебор всех людей)
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void getByName(){
        humanList.sort(new ComparatorByName());
    }
    public void getByAge(){
        humanList.sort(new ComporatorByAge());
    }

    public void addHuman(Human human) {
        if (!humanList.contains(human)){
            human.setId(humansId++);
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
        }
    }
}
