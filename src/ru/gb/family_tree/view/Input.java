package ru.gb.family_tree.view;

import java.util.Scanner;

public class Input {
    private Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    private String getInput(String regex, String mismatchMsg) {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("")) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else if (!input.matches(regex)) {
                System.out.println(mismatchMsg);
                System.out.print("Пожалуйста, повторите ввод: ");
            } else {
                return input;
            }
        }
    }

    public String getString(String regex, String mismatchMsg) {
       return getInput(regex, mismatchMsg);
    }

    public Integer getInt(String regex, String mismatchMsg) {
        return Integer.parseInt(getInput(regex, mismatchMsg));
    }
}
