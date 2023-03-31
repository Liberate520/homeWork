import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        Human human1 = new Human("Екатерина", "ж");
        Human human2 = new Human("Галина", "ж");
        Human human3 = new Human("Владимир", "м");
        Human human4 = new Human("Иван", "м");
        Human human5 = new Human("Евфалия", "ж");
        Human human6 = new Human("Дарья", "ж");

        human1.setMother(human2);
        human1.setFather(human3);
        human6.setFather(human3);
        human6.setMother(human2);
        human2.setMother(human5);
        human3.setFather(human4);

        FamilyTree famailytree = new FamilyTree();

        famailytree.addpeople(human1, human2, human3);
        famailytree.addpeople(human2, human5, null);
        famailytree.addpeople(human6, human2, human3);
        famailytree.addpeople(human3, null, human4);
        famailytree.addpeople(human4, null, null);
        famailytree.addpeople(human5, null, null);
        System.out.println(famailytree);

        System.out.println("Введите имя человека, которого нужно найти: ");
        String name1 = scan.nextLine();
        Human humanf = new Human("1", "ж");
        humanf = famailytree.findHuman(name1, humanf);

        if (humanf.getName().equals("1")) {
            System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", name1);
        } else {
            System.out.println(humanf);
        }
        scan.close();

        OutInput saveload = new Slfamailytree();
        saveload.save(famailytree);
        famailytree = (FamilyTree) saveload.load();
        System.out.println(famailytree);
    }
}