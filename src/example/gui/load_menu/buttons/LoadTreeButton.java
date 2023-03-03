package org.example.gui.load_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.main_menu.menu.MainMenu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadTreeButton extends SButton{
    private final String text;
    {
        text = "Загрузить дерево";
    }
    private final ConsoleUI consoleUI;

    public LoadTreeButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }




    @Override
    public void action() throws IOException {
        consoleUI.getPresenter().setCommandFromView("load", "", -1);
        boolean flag = false;
        while (!flag) {
            MainMenu mainMenu = new MainMenu(consoleUI);
            System.out.println(mainMenu);
            System.out.println("exit - завершить работу приложения");
            String input = consoleUI.getScanner().nextLine();
            if (input.equals("exit")){
                flag = true;
            } else {

                consoleUI.setPrintList(consoleUI.getPresenter().getPrintList());
                mainMenu.getButtons().get(Integer.parseInt(input) - 1).action();
            }
        }
    }

    @Override
    public String toString() {
        return text;
    }


}

