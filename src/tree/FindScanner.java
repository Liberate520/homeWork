package tree;

import java.util.Scanner;

public class FindScanner {

    public String findScanner() {
        System.out.printf("Введите имя для поиска: ");
        Scanner scn = new Scanner(System.in, "cp866");
        String findName = scn.nextLine();
        scn.close();
        return findName;
    }
}
