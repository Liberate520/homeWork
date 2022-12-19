package view;

import java.util.Scanner;

public class View {
    Scanner scn = new Scanner(System.in);

    public String inputKey(String str) {
        String key;
        System.out.print(str);
        key = scn.nextLine();
        return key;
    }
}
