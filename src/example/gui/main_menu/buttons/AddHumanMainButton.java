package org.example.gui.main_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;

import java.io.FileNotFoundException;
import java.io.IOException;


public class AddHumanMainButton extends SButton {
    private final String text;
    {
        text = "Добавить человека";
    }
    private final ConsoleUI consoleUI;

    public AddHumanMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        System.out.println("Введите Ф.И.О.\n");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("addH", input, -1);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
    }
    @Override
    public String toString() {
        return text;
    }
}
