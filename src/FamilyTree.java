package src;

import org.jetbrains.annotations.NotNull;
import src.comparator.HumanComparator;
import src.comparator.HumanComparatorByAge;
import src.comparator.HumanComparatorByLastName;
import src.comparator.SortBy;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends It> implements Serializable, Iterable<T> {


    private List<T> family;

    public FamilyTree(List<T> family) {
        if (family == null) {
            this.family = new ArrayList<>();
        } else {
            this.family = family;
        }
    }

    public FamilyTree() {
        this(null);
    }

    public List<T> getFamily() {
        return family;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------\n");
        for (T h :
                family) {
            result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
        }

        return result.toString();
    }

    public void addToFamily(T human) {
        if (family == null) {
            family = new ArrayList<>();
        }
        if (!family.contains(human)) {
            family.add(human);
        }
        for (It it :
                human.getChildren()) {
            addToFamily((T) it);
        }

    }


    private List<T> findFamilyList(String lastName) {
        List<T> result = new ArrayList<>();
        for (T human :
                family) {
            if (Objects.equals(human.getLastName(), lastName)) {
                result.add(human);
            }
        }
        return result;
    }

    public String getStatistics(T human) {
        if (family.contains(human)) {
            Statistics statistics = new Statistics();
            return statistics.getStatistics((It) human, (List<It>) getClildrenAndGrandsonsList(human));
        } else {
            return "Что-то пошло не так!";
        }
    }


    public List<T> getClildrenAndGrandsonsList(T human) {
        List<T> hlist = new ArrayList<>();
        hlist.add(human);
        List<T> result = createClildrenAndGrandsonsList(hlist);
        result.remove(0);
        return result;
    }

    private List<T> createClildrenAndGrandsonsList(List<T> lst) {
        List<T> result = new ArrayList<>(lst);
        int st = lst.size();
        for (T h :
                lst) {
            if (!h.getChildren().isEmpty()) {
                for (It it :
                        h.getChildren()) {
                    if (!result.contains(it)) {
                        result.add((T) it);
                    }
                }
            }
        }
        if (result.size() == lst.size()) {
            return result;
        } else {
            result = createClildrenAndGrandsonsList(result);
        }
        return result;
    }

    public List<T> findHumans(HashMap<String, String> hashMap) {
        FindHumans<T> fHumans = new FindHumans<>();
        return fHumans.findHumans(family, hashMap);
    }

    public void setFamily(List<T> family) {
        this.family = family;
    }

    public void sortByAge() {
        Collections.sort(family, new HumanComparatorByAge<T>());
    }

    public void sortByLastName() {
        Collections.sort(family, new HumanComparatorByLastName<T>());
    }

    public void sort(SortBy sortBy) {
        Collections.sort(family, new HumanComparator<T>(sortBy));
    }

    public int size() {
        return family.size();
    }

    public int maxId() {
        if (family == null) {
            return 0;
        }
        int maxId = 0;
        for (T u :
                family) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        return maxId;
    }

    public boolean delUnit(int id) {
        boolean flag = false;
        for (int i = 0; i < family.size(); i++) {
            if (family.get(i).getId() == id) {
                family.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public T getUnitById(int id) {
        for (T h :
                family) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    public String displayTree(T root) {
        ShowTree<T> showTree = new ShowTree<>();
        return showTree.displayTree(root);
    }

    public String getString(List<T> tlst) {
        StringBuilder stringBuilder = new StringBuilder();
        for (It it :
                tlst) {
            stringBuilder.append(it).append("\n");
        }
        return stringBuilder.toString();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(family);
    }
}
