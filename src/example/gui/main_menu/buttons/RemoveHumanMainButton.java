package org.example.gui.main_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class RemoveHumanMainButton extends SButton implements PrintList{
    private final String text;
    {
        text = "Удалить человека из списка";
    }
    private final ConsoleUI consoleUI;

    public RemoveHumanMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        boolean flag = false;
        while (!flag){
            System.out.println("<<< Выберете человека для удаления >>>\n");
            printList(consoleUI.getPrintList());
            System.out.println("m - главное меню\n");
            String input = consoleUI.getScanner().nextLine();
            if (input.equals("m")) {
                flag = true;
            } else {
                consoleUI.getPresenter().setCommandFromView("remove", "", Integer.parseInt(input) - 1);
                consoleUI.setPrintList(consoleUI.getPresenter().getPrintList());
            }
        }
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
