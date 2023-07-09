package family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;

import family_tree.human.Human;
import family_tree.human.Gender;
import family_tree.human.comparators.HumanComparatorByDataBirth;
import family_tree.human.comparators.HumanComparatorByFirstName;
import family_tree.human.comparators.HumanComparatorByLastName;

import java.util.Iterator;
import java.util.List;
public class FamilyTree implements Serializable, Iterable<Human> {
    private String name;
    private long humansId;
    private List<Human> humanList;
    public FamilyTree(String name) {
        this.name = name;
        humanList = new ArrayList<>();
    }
    public int getSize() {
        return humanList.size();
    }
    public FamilyTree(ArrayList<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree()     {
        this(new ArrayList<>());
    }
    public void addHuman(Human human) {
        if (human != null) {
            if (!(humanList.contains(human))) {
                this.humanList.add(human);
                human.setId(humansId++);

                addFather(human);
                addMother(human);
                addChildren(human);
            }
        }
    }
    //TODO реализовать метод поиска братьев
    public void addHumanAll(Human... humans) {
        for(Human human : humans) {
            this.addHuman(human);
        }
    }
    public void addFather(Human human) {
        if (human.getFather() != null) {
            Human father = human.getFather();
            father.addChildren(human);
        }
    }
    public void addMother(Human human) {
        if(human.getMother() != null) {
            Human mother = human.getMother();
            mother.addChildren(human);
        }
    }
    public void addChildren(Human human) {
        for (Human child: human.getChildren()) {
            if (human.getGender() == Gender.male)
                child.addFather(human);
            if (human.getGender() == Gender.female)
                child.addMother(human);
        }
    }
    public List<Human> getByFirstName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getFirstName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        return res;
    }
    // TODO подумать над реализацией вступления в семью
    public void setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
        }
    }

    private Human getById(long id) {
        for (Human human: humanList) {
            if (human.getId() == id)
                return human;
        }
        return null;
    }
    // TODO подумать над методом удаления члена семьи
    private boolean checkId(long id) {
        if (id >= humansId || id < 0 )
            return false;
        for (Human human: humanList) {
            if (human.getId() == id)
                return true;
        }
        return false;
    }
    // TODO реализовать метод развода супругов

    public String getProductInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое дерево " + this.name + ":\n");
        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return getProductInfo();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Human> getHumanList() {
        return humanList;
    }
    public void setHumanList(ArrayList<Human> humanList) {
        this.humanList = humanList;
    }
    public String getAllChildren(Human human) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Все дети " + human.getLastName() + " " + human.getFirstName() + " " + human.getMiddleName() + ":\n");
        for (Human child: human.getChildren()) {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByFirstName() {
        humanList.sort(new HumanComparatorByFirstName());
    }
    public void sortByLastName() {
        humanList.sort(new HumanComparatorByLastName());
    }
    public void sortByDataBirth() {
        humanList.sort(new HumanComparatorByDataBirth());
    }
}