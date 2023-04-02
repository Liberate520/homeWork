import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Human> humans = new ArrayList<>();

    public void addHuman(Human human) {
        humans.add(human);
    }

    @Override
    public String toString() {
        return humans.toString();
    }
}




