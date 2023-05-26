package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Human> people = new ArrayList<>();

        Human Masha = new Human("Masha", "woman");
        Human Sasha = new Human("Sasha", "man");
        Human Nikita = new Human("Nikita", "man", Sasha, Masha);
        people.add(Masha);
        people.add(Sasha);
        people.add(Nikita);
        System.out.println(Masha);
        System.out.println(Nikita);
        System.out.println("------------->");

        for (Human human : people) {
            if (human.father != null) {
                System.out.println(human + " (Отец: " + human.father.name + ", Мать: " + human.mother.name + ")");
            } else {
                System.out.println(human);
            }
        }
    }
}
