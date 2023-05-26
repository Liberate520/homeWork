package FamilyTree;

import com.sun.source.tree.ArrayTypeTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Human> people = new ArrayList<>();

            Human Misha = new Human("Misha", "man");
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

       for (Human human : people) {
            if (human.father != null) {
                System.out.println(human + " (Отец: " + human.father.name + ", Мать: " + human.mother.name + ")" + " 'child' -> " + human.children.toString());
            } else {
                System.out.println(human + " 'child' -> " + human.children.toString());
            }
        }

       System.out.println(Misha.name + " его 'мать' --> " + Misha.mother);
        System.out.println(Sasha.name + " его 'child' --> " + Sasha.children);
    }


}
