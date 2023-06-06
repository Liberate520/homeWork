package tree;

import java.util.ArrayList;
import java.util.List;

//https://github.com/Liberate520/homeWork/pull/559
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Yuriy", Gender.Male);
        Human human2 = new Human("Natalya", Gender.Female);
        Human human3 = new Human("Mikhail", Gender.Male);
        Human human4 = new Human("Evgeniy", Gender.Male);
        Human human5 = new Human("Filippa", Gender.Female);

        human1.setFather(human3);
        human4.setChild(human5);
        human4.setChild(human1);
        System.out.println(human1);
        List<Human> fl;
        fl = Human.fullList;
        System.out.println("fl = " + fl);
        System.out.println(human4.getChildren());
    }
}
