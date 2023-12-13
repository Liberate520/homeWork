import model.human.Human;
import model.tree.FamilyTree;
import model.writer.FileHandler;
import model.human.Gender;
import view.ConsoleUI;

import java.time.LocalDate;
public class Main {
//    private static FamilyTree load(){
//        String filePath = "src/model.writer/model.human.tree.txt";
//                FileHandler fileHandler = new FileHandler();
//        return (FamilyTree) fileHandler.read(filePath);
//    }
//
//    private static void save(FamilyTree tree) {
//        String filePath = "src/model.writer/model.human.tree.txt";
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(tree, filePath);
//    }
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();

//        FamilyTree familyTree = new FamilyTree();
//
//        Human father = new Human("Николай", "Федоров", Gender.Male);
//        father.setBirthday(LocalDate.of(1973, 1, 9));
//        familyTree.addMembers(father);
//
//        Human mother = new Human("Елена", "Федорова", Gender.Female);
//        mother.setBirthday(LocalDate.of(1977, 8, 16));
//        familyTree.addMembers(mother);
//
//        Human me = new Human("Артем", "Федоров", Gender.Male);
//        me.setBirthday(LocalDate.of(1998, 9, 16));
//        familyTree.addMembers(me);
//        father.setChild(me);
//        mother.setChild(me);
//
//
//        Human sister = new Human("Полина", "Федорова", Gender.Female);
//        sister.setBirthday(LocalDate.of(2006, 2, 12));
//        familyTree.addMembers(sister);
//        father.setChild(sister);
//        mother.setChild(sister);
//
//
//        System.out.println(familyTree);
//
//        save(familyTree);
    }
}