import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        FamilyTree ft = new FamilyTree();
        ft.add(new Human("Ivanov", "Ivan", Gender.Male));
        ft.add(new Human("Ivanova", "Irina", Gender.Female));
        ft.add(new Human("Ivanov", "Ignat", Gender.Male,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanov", "Ibrahim", Gender.Male,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
        ft.add(new Human("Ivanova", "Anastasia", Gender.Female,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));

        System.out.println("-".repeat(10));
        System.out.println(ft);

    }
}
