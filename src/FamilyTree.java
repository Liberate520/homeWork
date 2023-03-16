import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T humanlist) {
        if (humanlist == null) {
            return false;
        }
        if (!humanList.contains(humanlist)) {
            humanList.add(humanlist);
            if (humanlist.getFather() != null) {
                humanlist.getFather().addChild(humanlist);
            }
            if (humanlist.getMother() != null) {
                humanlist.getMother().addChild(humanlist);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String lastname, String firstname) {
        for (T human : humanList) {
            if (human.getFirstname().equals(firstname) && human.getLastname().equals(lastname)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Записей в дереве: ");
        res.append(humanList.size());
        res.append("\n");
        for (T human : humanList) {
            res.append(human.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new ComparatorByName<T>());
    }
}