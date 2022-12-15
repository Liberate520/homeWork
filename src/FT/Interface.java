package FT;

import java.util.Scanner;

public class Interface {
    public static void Call(Tree tree) {

        System.out.print("Введите имя человека для поиска родственных связей:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();

        SearchRelations.printWife(name, tree);
        SearchRelations.printSon(name, tree);
        SearchRelations.printSyster(name, tree);
        SearchRelations.printBrother(name, tree);
        SearchRelations.printFather(name, tree);
        SearchRelations.printHusbant(name, tree);
        SearchRelations.printDaughter(name, tree);
        SearchRelations.printMother(name, tree);
        SearchRelations.printGrandDaughter(name, tree);
        SearchRelations.printGrandFather(name, tree);
        SearchRelations.printGrandMother(name, tree);
        SearchRelations.printGrandSon(name, tree);
    }
}
