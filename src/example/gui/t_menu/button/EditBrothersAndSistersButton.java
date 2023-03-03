package org.example.gui.t_menu.button;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.main_menu.buttons.PrintList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class EditBrothersAndSistersButton extends SButton implements PrintList {
    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные о братьях и сестрах";
    }
    private final ConsoleUI consoleUI;

    public EditBrothersAndSistersButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        System.out.println("Внесите брата или сестру из списка");
        printList(consoleUI.getPrintList());
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("brothersAndSisters", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public void printList(ArrayList<Map<String, String>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (String s : list.get(i).keySet()) {
                System.out.printf("%d - %s%n", i + 1,  s);
            }
        }
    }
}
