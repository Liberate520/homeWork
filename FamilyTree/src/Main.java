import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human node1 = new Human("Ivanov", "Ivan");
        Human node2 = new Human("Ivanov", "Olga", node1);
        Human node3 = new Human("Petrov", "Sergey", node2);
        Human node4 = new Human("Petrov", "Sveta", node3);


        System.out.println("Перечень людей: " + Human.getPersons());

        System.out.println("Дети человека 1: " + node1.getChildren());
        System.out.println("Дети человека 2: " + node2.getChildren());
        System.out.println("Дети человека 3: " + node3.getChildren());

        System.out.println();

        System.out.println("Родители человека 1: " + node1.getParent());
        System.out.println("Родители человека 2: " + node2.getParent());
        System.out.println("Родители человека 3: " + node3.getParent());
        System.out.println("Родители человека 4: " + node4.getParent());
    }
}