package org.example.gui.main_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.t_menu.menu.SecondMenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AddEditDataMainButton extends SButton implements PrintList{
    private final String text;
    {
        text = "Добавить/изменить данные";
    }
    private final ConsoleUI consoleUI;

    public AddEditDataMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        boolean flag = false;
        while (!flag){
        System.out.println("<<< Выберете человека для изменения данных >>>\n");
        printList(consoleUI.getPrintList());
        String input = consoleUI.getScanner().nextLine();
        System.out.println("Человек для редактирования:");
        System.out.println(consoleUI.getPrintList().get(Integer.parseInt(input) - 1).values());
        SecondMenu secondMenu = new SecondMenu(consoleUI, Integer.parseInt(input) - 1);
        System.out.println(secondMenu);
        System.out.println("m - выход в предыдущее меню");
        input = consoleUI.getScanner().nextLine();
        if(input.equals("m")){
            flag = true;
        } else {
            secondMenu.getButtons().get(Integer.parseInt(input) - 1).action();
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
