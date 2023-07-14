package family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;

import family_tree.model.human.Gender;
import family_tree.model.human.comparators.HumanComparatorByAgeByFirstName;
import family_tree.model.human.comparators.HumanComparatorByDateBirth;
import family_tree.model.human.comparators.HumanComparatorByFirstName;
import family_tree.model.human.comparators.HumanComparatorByLastName;

import java.util.Iterator;
import java.util.List;
public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private String name;
    private long humansId;
    private List<E> humanList;
    public FamilyTree(String name) {
        this.name = name;
        humanList = new ArrayList<>();
    }
    public int getSize() {
        return humanList.size();
    }
    public FamilyTree(ArrayList<E> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree()     {
        this(new ArrayList<>());
    }
    public void addHuman(E human) {
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
    public void addHumanAll(E... humans) {
        for(E human : humans) {
            this.addHuman(human);
        }
    }
    public void addFather(E human) {
        if (human.getFather() != null) {
            E father = human.getFather();
            father.addChildren(human);
        }
    }
    public void addMother(E human) {
        if(human.getMother() != null) {
            E mother = human.getMother();
            mother.addChildren(human);
        }
    }
    public void addChildren(E human) {
        for (E child: human.getChildren()) {
            if (human.getGender() == Gender.male)
                child.addFather(human);
            if (human.getGender() == Gender.female)
                child.addMother(human);
        }
    }
    public List<E> getByFirstName(String name) {
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if (human.getFirstName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        return res;
    }
    // TODO подумать над реализацией вступления в семью
    public void setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
        }
    }

    private E getById(long id) {
        for (E human: humanList) {
            if (human.getId() == id)
                return human;
        }
        return null;
    }
    // TODO подумать над методом удаления члена семьи
    private boolean checkId(long id) {
        if (id >= humansId || id < 0 )
            return false;
        for (E human: humanList) {
            if (human.getId() == id)
                return true;
        }
        return false;
    }
    // TODO реализовать метод развода супругов

    public String getProductInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое дерево " + this.name + ":\n");
        for (E human: humanList) {
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
    public List<E> getHumanList() {
        return humanList;
    }
    public void setHumanList(ArrayList<E> humanList) {
        this.humanList = humanList;
    }
    public String getAllChildren(E human) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Все дети " + human.getLastName() + " " + human.getFirstName() + " " + human.getMiddleName() + ":\n");
        for (E child: human.getChildren()) {
            stringBuilder.append(child);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByFirstName() {
        humanList.sort(new HumanComparatorByFirstName<>());
    }
    public void sortByLastName() {
        humanList.sort(new HumanComparatorByLastName<>());
    }
    public void sortByDateBirth() {
        humanList.sort(new HumanComparatorByDateBirth<>());
    }
    public void sortByAgeByFirstName() {
        humanList.sort(new HumanComparatorByAgeByFirstName<>());
    }
}