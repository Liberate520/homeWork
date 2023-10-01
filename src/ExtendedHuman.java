import java.util.ArrayList;
import java.util.List;

public class ExtendedHuman extends Human {

    public ExtendedHuman(String fstName, String lstName, String bornDate, String deathDate, Gender gender) {
        super(fstName, lstName, bornDate, deathDate, gender);
    }

    public ExtendedHuman(String fstName, String lstName, String bornDate, Gender gender) {
        super(fstName, lstName, bornDate, gender);
    }

    public List<Human> getMainGen() {
        List<Human> grandparents = new ArrayList<>();

        for(Human parent : this.getParents()) {
            grandparents.addAll(parent.getParents());
        }

        return grandparents;
    }
}
