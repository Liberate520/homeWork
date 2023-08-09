package human;
import java.util.ArrayList;
import java.util.List;

public class AllHumans {
    private List<Humans> humanRelatives;

    public AllHumans() {
        humanRelatives = new ArrayList<>();
        humanRelatives.add(new Father());
        humanRelatives.add(new Mother());
    }

    public void relativesAll() {
        for (Humans humans: humanRelatives) {
            humans.relatives();
        }
    }
}
