import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Actionable> activities = new ArrayList<>();
        activities.add(new Vife());
        activities.add(new Husband());
        activities.add(new Grandparent());
        activities.add(new Uncle());

        Interactions interactions = new Interactions(activities);
        interactions.interactAll();
    }

    FamilyTree tree = new FamilyTree();

}
