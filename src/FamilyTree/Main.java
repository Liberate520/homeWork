package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Human> people = new ArrayList<>();

            Human Misha = new Human("Misha", "man");
            Human Olga = new Human("Olga", "woman");
            Human Masha = new Human("Masha", "woman");
            Human Sasha = new Human("Sasha", "man");
            Human Nikita = new Human("Nikita", "man", Sasha, Masha);



        people.add(Masha);
        people.add(Misha);
        people.add(Sasha);
        people.add(Nikita);
        System.out.println();
        System.out.println(Nikita);
        System.out.println("------------->");

        Nikita.AddChild(Misha);
        Nikita.AddChild(Olga);


    for (Human human : people) {
        System.out.println(human);
    }
        System.out.println(Sasha.name + " его 'child' --> " + Sasha.children);
        System.out.println(Nikita.children);

        System.out.println(Nikita.GetParent());
        System.out.println(Misha.GetParent());

        System.out.println(Nikita.GetChild());
        System.out.println("------------->");
        System.out.println(Olga);
        System.out.println(Olga.GetParent());
        System.out.println(Nikita.GetChild());

        Olga.AddParent(Misha);
        System.out.println(Olga.GetParent());
        System.out.println(Misha.GetChild());
        System.out.println(Nikita.GetChild());

        Family pipkins = new Family("Pipkins");

        pipkins.setFamily(Sasha, Masha, Nikita);
        pipkins.setFamily(Olga, Misha);

        System.out.println(pipkins);
    }
}
