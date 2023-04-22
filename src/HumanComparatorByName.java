import java.util.Comparator;

public class HumanComparatorByName<H> implements Comparator<Human> {
    @Override
    public int compare(Human human_1, Human human_2) {
        return human_1.getName().compareTo(human_2.getName());
    }
}