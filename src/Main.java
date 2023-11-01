import java.io.*;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args){
        int index = 1;
        Human human1 = new Human(index++, "Masha", Gender.female, LocalDate.of(1960, 10, 5));
        Human human2 = new Human(index++, "Sveta", Gender.female, LocalDate.of(1985, 5, 15));
        Human human3 = new Human(index++, "Misha", Gender.male, LocalDate.of(1958, 10, 26));
        Human human4 = new Human(index++, "Petr", Gender.male, LocalDate.of(1935, 1, 7));
        Human human5 = new Human(index++, "Ivan", Gender.male, LocalDate.of(1990, 7, 4));
        human2.setParent(human3);
        human2.setParent(human1);
        human1.setParent(human4);
        human5.setParent(human3);
        human5.setParent(human1);
        human4.setDeathday(LocalDate.of(2000, 12, 4));

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.getAllHuman();
        familyTree.getHuman(1);

        System.out.println("-----");

        FileHandler fileHandler = new FileHandler(familyTree);
        fileHandler.output();
        FamilyTree familyTreeRestored = fileHandler.input();
        familyTree.getAllHuman();

        System.out.println("-----");

        familyTree.sortByName();
        familyTree.getAllHuman();

        System.out.println("-----");

        familyTree.sortByBirthDay();
        familyTree.getAllHuman();
    }
}
