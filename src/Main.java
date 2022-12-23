import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Human father = new Human("Станислав", 1960, "male");
        Human mother = new Human("Василиса", 1985, "female");
        Human humanM1 = new Human("Вася", 1995, "male");
        Human humanF = new Human("Екатерина", 2000, "female");
        Human humanM2 = new Human("Вася", 1998, "male");
        Human human2 = new Human("Анна");

        System.out.println("Вывод humanов напрамую:");
        System.out.println(father);
        System.out.println(mother);
        System.out.println(humanM1);
        System.out.println(humanM2);
        System.out.println(humanF);
        System.out.println(human2);

        FamilyTree tree = new FamilyTree();
        tree.addHuman(new Human("Владимир", 1980, "male"), father, null);
        tree.addHuman(father, null, null);
        tree.addHuman(humanM1, father, mother);
        tree.addHuman(humanM2, father, mother);
        tree.addHuman(human2, humanM1, humanF);
        tree.addHuman(new Human("Анастасия"), null, human2);
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree:");
        System.out.println(tree.findByName("Анна"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с одним именем:");
        System.out.println(tree.findAllByName("Вася"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с помощью метода showAllToConsole");
        tree.showAllInConsole();
        System.out.println();

        InputOutputBin inputOutputBin = new InputOutputBin();
        try {
            System.out.println("INPUT/OUTPUT HUMAN:");
            inputOutputBin = new InputOutputBin();
            inputOutputBin.saveAs(humanF, "human.bin");
            System.out.println(inputOutputBin.readFrom("human.bin"));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("INPUT/OUTPUT HUMAN TREE:");
            inputOutputBin.saveAs(tree, "humansList.bin");
            Serializable restore = inputOutputBin.readFrom("humansList.bin");
            FamilyTree restoFamilyTree = (FamilyTree) restore;
            System.out.println(restoFamilyTree.getHumans());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
