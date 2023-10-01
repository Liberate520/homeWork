import java.util.ArrayList;
import java.util.List;

public class GenerationMain extends Human {

    public GenerationMain(String fstName, String lstName, String bornDate, String deathDate, Gender gender) {
        super(fstName, lstName, bornDate, deathDate, gender);
    }

    public GenerationMain(String fstName, String lstName, String bornDate, Gender gender) {
        super(fstName, lstName, bornDate, gender);
    }

    public List<Human> getGrandchildren() {
        List<Human> result = new ArrayList<Human>();
        for(Human child: this.getChildren()) {
            for (Human grandchild : child.getChildren()) {
                result.add(grandchild);
            }
        }
        return result;
    }
    

