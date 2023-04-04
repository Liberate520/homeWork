import java.util.Comparator;

public class HumanCompareByNumberChild implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getNumChildren(), o2.getNumChildren());
    }

//    @Override
//    public int compare(Human o1, Human o2) {
//        return Integer.compare(o1.getChildList().size(), o2.getChildList().size());
//    }
}
