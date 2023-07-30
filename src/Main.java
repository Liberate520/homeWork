import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/tree.out";
// Запись в файл
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = testTree();
        System.out.println(tree);
        fileHandler.save(tree, filePath);
// Чтение из файла
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
//        System.out.println(tree);

    }
    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human fedor = new Human("Федор", Gender.Male, LocalDate.of(1966,2,2));
        Human galina = new Human("Галина", Gender.Female, LocalDate.of(1970,3,3));
        tree.add(fedor);
        tree.add(galina);
        tree.setWedding(fedor.getId(), galina.getId());

        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1999, 3, 7),
                fedor, galina);
        Human andrey = new Human("Андрей", Gender.Male, LocalDate.of(2003,9,24),
                fedor, galina);
        tree.add(elena);
        tree.add(andrey);

        Human svetlana = new Human("Светлана", Gender.Female, LocalDate.of(1939,5,9));
        svetlana.addChild(fedor);
        tree.add(svetlana);

        return tree;
    }

}