import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Human person0 = new Human(0, "Иван", "Иванов",
                "01.01.1975", null, 1, 2, 7);
        //Создаем родителей Ивана
        Human person1 = new Human(1, "Петр", "Иванов",
                "01.01.1950", "", 3, 4, 2);
        Human person2 = new Human(2, "Анна", "Иванова",
                "01.01.1955", "", 5, 6, 1);

        // Создаем дедушку и бабушку с отцовской стороны Ивана
        Human person3 = new Human(3, "Иван", "Иванов",
                "01.01.1925", "01.01.1985", 0, 0, 4);
        Human person4 = new Human(4, "Мария", "Иванова",
                "01.01.1930", "01.01.1995", 0, 0,3);

        // Создаем дедушку и бабушку с материнской стороны Ивана
        Human person5 = new Human(5, "Александр", "Петров",
                "01.01.1935", "01.01.2000", 0, 0, 6);
        Human person6 = new Human(6, "Екатерина", "Петрова",
                "01.01.1940", "", 0, 0, 5);
        Human person7 = new Human(7, "Екатерина", "Иванова",
                "10.01.1980", null, 1, 2, 0);
        Human person8 = new Human(8, "Виктория", "Иванова",
                "10.01.1980", null, 0, 7, -1);

        ArrayList<Human> people = new ArrayList<>();
        people.add(person0);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);

        System.out.println(person0.toString());
        System.out.println(person3.findSpouse(person3,people));
        System.out.println(person0.findKids(person0,people));
    }
}
