

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Human human4 = new Human("Olga", "Serduk", LocalDate.of(1965, 3, 13));
        Human human5 = new Human("Sergey", "Kartaev", LocalDate.of(1964, 6, 15));

        Human human1 = new Human("Nikolay", "Kartaev", LocalDate.of(1987, 1, 3), human4, human5, Gender.Male);
        Human human2 = new Human("Anastasia", "Kartaeva", LocalDate.of(1986, 8, 26), Gender.Female);
        Human human3 = new Human("Platon", "Kartaev", LocalDate.of(2022, 1, 30), human2, human1, Gender.Male);

        human1.addChildF(human3);

        ArrayList<Human> children = human1.getChildren();
        for (Human human : children) {
            System.out.println(human);
        }

        System.out.println(human3.getFather());
        System.out.println(human3.getMother());

        System.out.println(human1.getParents());
        System.out.println(human3.getParents());

    }

}
