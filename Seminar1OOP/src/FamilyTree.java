import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree(List<Human> humenList) {
        this.humanList = humenList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getAllHuman() {
        return new ArrayList<>(humanList);
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, Comparator.comparing(Human::getYearOfBirth));
    }

    public void sortByName() {
        Collections.sort(humanList, Comparator.comparing(Human::getName));
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    private static class HumanIterator implements Iterator<Human> {
        private List<Human> humanList;
        private int index;

        public HumanIterator(List<Human> humanList) {
            this.humanList = humanList;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < humanList.size();
        }

        @Override
        public Human next() {
            return humanList.get(index++);
        }
    }
}
