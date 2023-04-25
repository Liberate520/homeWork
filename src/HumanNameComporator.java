import java.util.Comparator;

public class HumanNameComporator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getFirstName().compareTo(human2.getFirstName());
    }
}
