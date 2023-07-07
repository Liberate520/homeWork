import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree ft = new FamilyTree();
        ft.add(new Human("Ivanov", "Ivan", Gender.Male));
        ft.add(new Human("Ivanova", "Irina", Gender.Female));
        ft.add(new Human("Ivanov", "Ignat", Gender.Male, ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanov", "Ibrahim", Gender.Male, ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanova", "Anastasia", Gender.Female, ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));

        System.out.println(ft);
        System.out.println("-".repeat(10));
//        String path = "src/testWrite.txt";
//        WriteAndRead war = new WriteAndRead();
//        war.writeFile(path, ft);

//        FamilyTree tree = (FamilyTree) war.readFile(path);
//        System.out.println(tree);
    }

}