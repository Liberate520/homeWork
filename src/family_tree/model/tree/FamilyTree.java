package family_tree.model.tree;

import family_tree.model.human.comparator.HumanComparatorByAge;
import family_tree.model.human.comparator.HumanComparatorById;
import family_tree.model.human.comparator.HumanComparatorByName;
import family_tree.model.infrastucture.de_serelization.My_Serialization;
import family_tree.model.tree.tree_service.HumanIterator;
import family_tree.model.tree.tree_service.TreeItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class FamilyTree<E extends TreeItem<E>> implements My_Serialization, Iterable<E> {
   public static final long serialVersionUID = My_Serialization.serialVersionUID;
    private long humanId;
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addToHumanList(E e) {
        if (e == null) {
            return false;
        }
        if (!humanList.contains(e)) {
            humanList.add(e);
            e.setId(humanId++);
            addToParents(e);
            addToChildren(e);
            return true;
        }
        return false;
    }

    private void addToParents(E e) {
        for (E parent : e.getParents()) {
            parent.addChild(e);
        }
    }

    private void addToChildren(E e) {
        for (E child : e.getChildren()) {
            child.addParent(e);
        }
    }

    public List<E> getByFullName(String surname, String first_name, String patronymic) {
        List<E> res = new ArrayList<>();
        StringBuilder fullName = new StringBuilder();
        fullName.append(surname).append(" ").append(first_name).append(" ").append(patronymic);
        for (E human : humanList) {
            if (human.getFullName().equalsIgnoreCase(fullName.toString())) {
                res.add(human);
            }
        }
        return res;
    }


    public boolean setWedding(long humanId_1, long humanId_2) {
        if (checkId(humanId_1) && checkId(humanId_2)) {
            E human_1 = getById(humanId_1);
            E human_2 = getById(humanId_2);
            if (human_1.getSpouse() == null && human_2.getSpouse() == null) {
                human_1.setSpouse((E) human_2);
                human_2.setSpouse((E) human_1);
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
        for (E human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<E> humanList) {
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
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById<>());
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        return false;
    }

    @Override
    public Object load(String filePath) {
        return null;
    }
}



