package OOPjava1.src;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Human person1 = new Human("Васильев", "Влад", "1980");
        Human person2 = new Human("Васильев", "Григорий", "2001");
        Human person3 = new Human("Шарапов", "Артем", "1946");
        Human person4 = new Human("Карпенко", "Сергей", "1950");
        Human person5 = new Human("Васильева", "Наталья", "1981");
        List<Human> people = new ArrayList<Human>();
        people.add(person1); people.add(person2);
        people.add(person3); people.add(person4);
        people.add(person5);
        person1.setChildren(person2); person5.setChildren(person2);
        person1.setParents(person3); person5.setParents(person4);
        person3.setChildren(person1); person4.setChildren(person5);
        person2.setParents(person1);

        Tree family = new Tree(people);
        family.getStart();
    }

}