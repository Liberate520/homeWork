import java.io.*;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree tree = new Tree();

        Human father = new Human("Иван","мужской", LocalDate.of(1987, 7, 20));
        Human mother = new Human("Мария", "женский", LocalDate.of(1989, 5, 15));
//        Human human = new Human("Игорь","мужской", LocalDate.of(1987, 7, 20));
//        Human human = new Human("Наталья", "мужской", LocalDate.of(1989, 5, 15));

        tree.addHuman(father);
        tree.addHuman(mother);
//        tree.addHuman(volodia);
//        tree.addHuman(sergey);

        Human daughter = new Human("Василина", "женский", LocalDate.of(2015, 8, 11), father, mother);
        Human son = new Human("Коля","мужской", LocalDate.of(2011, 1, 16), father, mother);

        tree.addHuman(daughter);
        tree.addHuman(son);

//        не получается сделать так чтобы можно было дозаписать
        tree.writeExternal(father,"test.ser");
        tree.writeExternal(mother, "test.ser");
        tree.writeExternal(daughter, "test.ser");
        tree.writeExternal(son, "test.ser");
        System.out.println("Результат чтения: " + tree.readExternal("test.ser"));
        System.out.println();




        System.out.println(tree.getHumanList());

        Human find = tree.findHumanName("Иван");
        System.out.print("Результат поиска: ");
        System.out.println(find);
        System.out.println();

        List<Human> children = tree.getChildrenOfHuman(daughter);
        System.out.println(daughter);
        for (Human child : children) {
            System.out.println("Дети: " + child.getName());
        }
        System.out.println();

        // Вывод списка родителей при выборе ребенка
        List<Human> parents = tree.getParentsOfHuman(father);
        System.out.println(father);
        for (Human parent : parents) {
            System.out.println("Родители: " + parent.getName());
        }

    }
    }
