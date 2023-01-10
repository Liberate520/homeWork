import java.util.Comparator;

public class ComparatorByDate /*extends Family<People> */ implements Comparator<People> {

    @Override
    public int compare(People o1, People o2) {
        return Integer.compare(o1.getBirthDate(), o2.getBirthDate());
    }
}
