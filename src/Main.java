

import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FamilyTree tree = load();
        FamilyTree tree = testTree();
        System.out.println(tree);
        save(tree);
    }


    private static FamilyTree load(){
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree){
        String filePath = "src/ru/gb/family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }


    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human human1 = new Human("Петр", "Романов", "Алексеевич", Gender.Male, LocalDate.of(1672, 6, 9), LocalDate.of(1725, 2, 8));
        Human human2 = new Human("Евдокия", "Лопухина", "Федоровна", Gender.Female, LocalDate.of(1669, 8, 9), LocalDate.of(1731, 9, 7));

        tree.add(human1);
        tree.add(human2);

        Human human3 = new Human("Алексей", "Романов", "Петрович", Gender.Male, LocalDate.of(1690, 2, 28), LocalDate.of(1718, 7, 7), human2, human1);

        tree.add(human3);

        return tree;
    }
}
