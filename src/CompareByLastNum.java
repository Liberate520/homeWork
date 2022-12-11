import java.util.Comparator;

public class CompareByLastNum implements  Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1 % 10, o2 % 10);
    }
}
