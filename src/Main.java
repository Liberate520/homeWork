import java.io.*;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree tree = new Tree();

        tree.add(new Human("Иван", "мужской", LocalDate.of(1987,07,15),null));
        tree.add(new Human("Ирина", "женский", LocalDate.of(1990,05,11),null));

        tree.add(new Human("Василина", "женский", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2010,1,1), null));
        tree.add(new Human("Коля", "мужской", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2012,2,2), null));

        System.out.println(tree.getInfo());




//        не получается сделать так чтобы можно было дозаписать
//        tree.writeExternal(father,"test.ser");
//        tree.writeExternal(mother, "test.ser");
//        tree.writeExternal(daughter, "test.ser");
//        tree.writeExternal(son, "test.ser");
//        System.out.println("Результат чтения: " + tree.readExternal("test.ser"));
//        System.out.println();






//        Human find = tree.findHumanName("Иван");
//        System.out.print("Результат поиска: ");
//        System.out.println(find);
//        System.out.println();







    }
    }
