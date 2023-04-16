import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        List<Human> people = new ArrayList<>();
        people.add(new Human("Иван", "Иванов", "25.10.1990", Gender.Male));
        people.add(new Human("Светлана", "Светлова", "14.05.1993", Gender.Female));
        people.add(new Human("Екатерина", "Иванова", "05.03.2012", Gender.Female, people.get(1), people.get(0)));
        people.add(new Human("Петр", "Иванов", "10.08.2015", Gender.Male, people.get(1), people.get(0)));
        people.add(new Human("Михаил", "Иванов", "18.12.2017", Gender.Male, people.get(1), people.get(0)));
        people.add(new Human("Сидр", "Светлов", "25.02.1970", Gender.Male));

        people.get(1).setFather(people.get(5));

        System.out.println(people.get(1).getFather());

        System.out.println("Наши мамы:");
        for (Human human: people
             ) {
            System.out.println(familyTree.getMother(human));
        }
        System.out.println("Наши папы:");
        for (Human human: people
        ) {
            System.out.println(familyTree.getFather(human));
        }
        System.out.println("Братья для " + people.get(2).getFullName() + ':');
        System.out.println(familyTree.getBrothers(people.get(2), people));

        System.out.println("Сестры для " + people.get(3).getFullName() + ':');
        System.out.println(familyTree.getSisters(people.get(3), people));
    }

}
