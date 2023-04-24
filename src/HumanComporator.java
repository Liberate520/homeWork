import java.util.Comparator;

public class HumanComporator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getBirthYear() - o1.getBirthYear();
    }
    
}
