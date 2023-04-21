import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public static void main(String[] args) {
        List<Human> children1 = new ArrayList<>();

        Human human1 = new Human(Gender.Male, "Юрий", "Алексеев", null, null, children1);
          Human human2 = new Human(Gender.Female, "Екатерина", "Алексеева", null, null, children1);
          Human human3 = new Human(Gender.Female, "Валерия", "Алексеева", human2, human1, null);

          children1.add(human3);

        System.out.println(human1.toString());


    }
}
