import java.util.ArrayList;
import java.util.List;

public class FamilyThree {
    private static List<Human> humans = new ArrayList<>();

    public static List<Human> getHumans() {

        return humans;
    }

    public static void addHuman(Human human) {

        humans.add(human);
    }


}
