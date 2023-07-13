import human.*;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree ft = new FamilyTree();
        ft.add(new Human("Ivanov", "Ivan", Gender.Male, LocalDate.of(1990, 02,01)));
        ft.add(new Human("Ivanova", "Irina", Gender.Female, LocalDate.of(1991, 02, 01)));
        ft.add(new Human("Ivanov", "Ignat", Gender.Male, LocalDate.of(2020, 03,01), (Human) ft.getByName("Ivanov Ivan"), (Human) ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanov", "Ibrahim", Gender.Male, LocalDate.of(2018, 04, 01), (Human) ft.getByName("Ivanov Ivan"), (Human) ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanova", "Anastasia", Gender.Female, LocalDate.of(2019,05,01), (Human) ft.getByName("Ivanov Ivan"), (Human) ft.getByName("Ivanova Irina")));

        System.out.println(ft);
        System.out.println("-".repeat(10));
//        String path = "src/testWrite.txt";
//        write_read.WriteAndRead war = new write_read.WriteAndRead();
//        war.writeFile(path, ft);

//        FamilyTree tree = (FamilyTree) war.readFile(path);
//        System.out.println(tree);
        System.out.println("Sorted by name:");
        ft.sortByName();
        System.out.println(ft);

        System.out.println("-".repeat(10));
        System.out.println("Sorted by birthDay:");
        ft.sortByBirthDay();
        System.out.println(ft);

    }

}