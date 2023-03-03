package org.example.gui.load_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.main_menu.menu.MainMenu;

import java.io.FileNotFoundException;
import java.io.IOException;


public class AddTreeButton extends SButton{     // в стадии разработки
    private final String text;
    {
        text = "Создать новое дерево";
    }
    private final ConsoleUI consoleUI;

    public AddTreeButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }




    @Override
    public void action() throws IOException {
        boolean flag = false;
        while (!flag) {
            MainMenu mainMenu = new MainMenu(consoleUI);
            System.out.println(mainMenu);
            String input = consoleUI.getScanner().nextLine();
            if (input.equals("exit - завершить работу приложения")){
                flag = true;
            } else {

                mainMenu.getButtons().get(Integer.parseInt(input) - 1).action();
        }
        }

    }

    @Override
    public String toString() {
        return text;
    }


}

