import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)
    {
        Presenter presenter = new Presenter();

        List<Human> people = new ArrayList<>();
        people.add(presenter.createHuman("m1", 1, Gender.Male));
        people.add(presenter.createHuman("f1", 1, Gender.Female));
        people.add(presenter.createHuman("m1c1", 1, Gender.Male));
        people.add(presenter.createHuman("f1c2", 1, Gender.Female));

        for (Human human : people) {
            System.out.println(presenter.humanToString(human));
        }

        for (var item : presenter.createParamTree(people)) {
            System.out.println(item.toString());
        }

        presenter.saveTree("out", presenter.createTree(people));
    }
}
