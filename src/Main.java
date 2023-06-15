import java.io.*;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "test.txt";
        FileOperations fileOperations = new Save();

        Tree tree = (Tree) fileOperations.read(filePath);
//        Tree tree = new Tree();

        tree.add(new Human("Иван", "мужской", LocalDate.of(1987,07,15),null));
        tree.add(new Human("Ирина", "женский", LocalDate.of(1990,05,11),null));

        tree.add(new Human("Василина", "женский", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2010,1,1), null));
        tree.add(new Human("Коля", "мужской", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2012,2,2), null));

        fileOperations.write(tree, filePath);

        System.out.println(tree.getInfo());



    }
    }
