import writer.FileHandler;

import java.time.LocalDate;
public class Main {
    private static FamilyTree load(){
        String filePath = "src/writer/tree.txt";
                FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree) {
        String filePath = "src/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree("Fedorov's");

        Human father = new Human("Федоров", "Николай", Gender.Male);
        father.setBirthday(LocalDate.of(1973, 1, 9));
        System.out.println(father);
        familyTree.addMembers(father);

        Human mother = new Human("Федорова", "Елена", Gender.Female);
        mother.setBirthday(LocalDate.of(1977, 8, 16));
        System.out.println(mother);
        familyTree.addMembers(mother);

        Human me = new Human("Федоров", "Артем", Gender.Female);
        me.setBirthday(LocalDate.of(1998, 9, 16));
        System.out.println(me);
        familyTree.addMembers(me);
        father.setChild(me);
        mother.setChild(me);
        System.out.println(father.getChildren());
        System.out.println(me.getParents());

        Human sister = new Human("Федорова", "Полина", Gender.Female);
        sister.setBirthday(LocalDate.of(2006, 2, 12));
        System.out.println(sister);
        familyTree.addMembers(sister);
        father.setChild(sister);
        mother.setChild(sister);
        System.out.println(father.getChildren());
        System.out.println(sister.getParents());

        System.out.println(familyTree);
        save(familyTree);
    }
}