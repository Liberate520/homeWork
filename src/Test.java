import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)
    {
        Human h1 = new Human("m1", 1980, Gender.Male);
        Human h2 = new Human("f1", 1985, Gender.Male);

        Human c1 = new Human("m1c1", 2002, Gender.Male);
        Human c2 = new Human("m1c2", 2003, Gender.Male);
        Human c3 = new Human("m1c3", 2005, Gender.Female);
        Human c4 = new Human("m1c4", 2001, Gender.Female);

        h1.AddChild(c1);
        h1.AddChild(c2);
        h1.AddChild(c3);
        h1.AddChild(c4);

        h2.AddChild(c2);
        h2.AddChild(c3);
        h2.AddChild(c4);

        List<Human> people = new ArrayList<>();
        people.add(h1);
        people.add(h2);
        people.add(c1);
        people.add(c2);
        people.add(c3);
        people.add(c4);

        ParamTree<Human> tree = new ParamTree<Human>(people);
        
        for (Human h : tree) {
            System.out.println(h);
        }

        System.out.println(tree.sortedByBirthYear());
        System.out.println(tree.sortedByName());
    }
}
