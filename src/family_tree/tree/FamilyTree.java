package family_tree.tree;

import family_tree.human.Human;
import family_tree.human.comparator.HumanComparatorByAge;
import family_tree.human.comparator.HumanComparatorById;
import family_tree.human.comparator.HumanComparatorByName;
import family_tree.infrastucture.de_serelization.My_Serialization;
import family_tree.tree.tree_service.HumanIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class FamilyTree implements My_Serialization, Iterable<Human> {
   public static final long serialVersionUID = My_Serialization.serialVersionUID;
    private long humanId;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addToHumanList(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getByFullName(String surname, String first_name, String patronymic) {
        List<Human> res = new ArrayList<>();
        StringBuilder fullName = new StringBuilder();
        fullName.append(surname).append(" ").append(first_name).append(" ").append(patronymic);
        for (Human human : humanList) {
            if (human.getFullName().equalsIgnoreCase(fullName.toString())) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getByName(String first_name, String patronymic) {
        List<Human> res = new ArrayList<>();
        StringBuilder fullName = new StringBuilder();
        fullName.append(first_name).append(" ").append(patronymic);
        for (Human human : humanList) {
            if (human.getFullName().equalsIgnoreCase(fullName.toString())) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getBySurname(String surname) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getSurname().equalsIgnoreCase(surname)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId_1, long humanId_2) {
        if (checkId(humanId_1) && checkId(humanId_2)) {
            Human human_1 = getById(humanId_1);
            Human human_2 = getById(humanId_2);
            if (human_1.getSpouse() == null && human_2.getSpouse() == null) {
                human_1.setSpouse(human_2);
                human_2.setSpouse(human_1);
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= humanId || id < 0) {
            return false;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void clearHumanList() {
        this.humanList.clear();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nСемейное древо содержит ");
        sb.append(humanList.size());
        sb.append(" членов:\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    @Override
    public void forEach(Consumer<? super Human> action) {
        Iterable.super.forEach(action);
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById());
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }
}



