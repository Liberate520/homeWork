import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;
    private long humansId;

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    /**
     * Метод принимает человека и если такого человека еще нет в списке, добавляет его в список
     * так же добавляет его к родителям(если они есть) и к детям (если они есть)
     * @param human - человек
     */
    public void addHuman(Human human) {
        if (human != null && !humans.contains(human)) {
            humans.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
        } else System.out.println("Ошибка");
    }

    /**
     * принимает человека и добавляет его в качестве ребенка родителям (если они есть),
     * если родителя нет то цикл продолжается без добавления ему ребенка
     * @param human
     */
    private void addToParents(Human human) {
        List<Human> parents = new ArrayList<>();
        parents.add(human.getMother());
        parents.add(human.getFather());
        for (Human parent : parents){
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

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
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
    private List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null)
            return null;
        List<Human> res = new ArrayList<>();
        List<Human> parents = new ArrayList<>(List.of(human.getMother(),
                human.getFather()));
        for (Human parent : parents){
            for (Human child : parent.getChildren()){
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
    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humans){
            if (human.getName().equalsIgnoreCase(name))
                res.add(human);
        }
        return res;
    }

    /**
     * принимает 2 id, с помощью метода getById инициализируем 2 объекта Human,
     * далее передаем их в перегруженный метод setWedding(Human, Human)
     * @param humanId1
     * @param humanId2
     * @return
     */
    public boolean setWedding (long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    /**
     * принимает 2 объекта Human, методом .getSpouse проверяет нет ли у объектов супругов(Spouse)
     * если супругов нет, методом setSpouse устанавливает им супргов(друг друга)
     * @param human1
     * @param human2
     * @return
     */
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    /**
     * принимает 2 id, с помощью метода getById инициализируем 2 объекта Human,
     * далее передаем их в перегруженный метод setDivorce(Human, Human)
     * @param humanId1
     * @param humanId2
     * @return
     */
    public boolean setDivorce(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    /**
     * принимает 2 объекта Human, методом .getSpouse проверяет являются ли объекты супругами(Spouse)
     * друг друга, методом setSpouse устанавливает им супргов(null - отсутсвует)
     * @param human1
     * @param human2
     * @return
     */
    public boolean setDivorce(Human human1, Human human2){
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
            Human human = getById(humanId);
            return humans.remove(human);
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
        for (Human human : humans){
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

    private Human getById(long id){
        for (Human human: humans){
            if (human.getId()==id){
                return human;
            }
        }
        return null;
    }

    /**
     * метод выводящий в консоль все объекты из списка
     */
    public void getAllHumans() {
        for (Human human : humans){
            System.out.println(human);
        }

    }

}
