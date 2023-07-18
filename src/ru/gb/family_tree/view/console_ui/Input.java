package ru.gb.family_tree.view.console_ui;

import java.util.Scanner;

public class Input {
    private Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    private String getInput(String startMsg, String regex, String mismatchMsg) {
        if (!startMsg.equals(""))
            System.out.print(startMsg + ": ");
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

    public String getString(String startMsg) {
       return getInput(startMsg, ".*", "Ошибка ввода");
    }

    public String getString(String startMsg, String regex, String mismatchMsg) {
        return getInput(startMsg, regex, mismatchMsg);
    }

    public Integer getInt(String startMsg, String regex, String mismatchMsg) {
        return Integer.parseInt(getInput(startMsg, regex, mismatchMsg));
    }
}
