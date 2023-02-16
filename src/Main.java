import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Human> person = new ArrayList<>();
        person.add(new Human("Павел", Sex.Male));
        person.add(new Human("Александр", Sex.Male));
        person.add(new Human("Лейла", Sex.Female));

        for (var p :
                person) {
            System.out.println(p.toString());
        }

    }
}
