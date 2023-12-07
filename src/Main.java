import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //FamilyTree tree = testTree();
        FamilyTree tree = load();
        System.out.println(tree);

        //save(tree);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human Elena = new Human("Elena", Gender.Female, LocalDate.of(1967, 4, 22));
        Human Rustam = new Human("Rustam", Gender.Male, LocalDate.of(1967,6,5));

        tree.add(Rustam);
        tree.add(Elena);
        tree.setWedding(Rustam, Elena);

        Human Timur = new Human("Timur", Gender.Male, LocalDate.of(1997, 9, 30), Elena, Rustam);
        tree.add(Timur);

        return tree;
    }

    static void save(FamilyTree tree){
        String fileName = "src/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, fileName);
    }

    static FamilyTree load(){
        String fileName = "src/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.load(fileName);
    }
}