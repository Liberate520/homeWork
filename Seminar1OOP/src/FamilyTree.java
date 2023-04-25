import java.util.*;

public class FamilyTree<T extends Human> implements Iterable<T> {
    private List<T> humanList;

    public FamilyTree(List<T> humenList) {
        this.humanList = humenList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(T human) {
        humanList.add(human);
    }

    public List<T> getHumanByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public List<T> getAllHuman() {
        return new ArrayList<>(humanList);
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, Comparator.comparing(Human::getYearOfBirth));
    }

    public void sortByName() {
        Collections.sort(humanList, Comparator.comparing(Human::getName));
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }
}
