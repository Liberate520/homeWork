import java.util.Comparator;

public class HumanComporatorByAge implements Comparator<Human>{
    @Override
    public int compare (Human o1, Human o2){
        return o1.getDateBirthday().compareTo(o2.getDateBirthday());
    }
}
