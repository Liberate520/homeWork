package Human;

public class ComparatorByFirstName implements HumanComparator {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
