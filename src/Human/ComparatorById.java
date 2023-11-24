package Human;

public class ComparatorById implements HumanComparator {
    @Override
    public int compare(Human o1, Human o2) {
        return (int) o1.getId() - (int) o2.getId();
    }
}
