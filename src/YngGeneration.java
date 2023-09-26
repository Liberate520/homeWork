import java.util.ArrayList;
import java.util.List;

public class YngGeneration extends Human {

    public YngGeneration(String fstName, String lstName, String bornDate, String deathDate, Gender gender) {
        super(fstName, lstName, bornDate, deathDate, gender);
    }

    public YngGeneration(String fstName, String lstName, String bornDate, Gender gender) {
        super(fstName, lstName, bornDate, gender);
    }

    public List<Human> getMainGen() {
        List<Human> result = new ArrayList<Human>();
        for(Human parent: this.getParents()) {
            for (Human par : parent.getParents()) {
                result.add(par);
            }
        }
        return result;
    }
}
