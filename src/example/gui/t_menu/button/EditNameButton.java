package org.example.gui.t_menu.button;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EditNameButton extends SButton {
    private final Integer indexHuman;

    private final String text;
    {
        text = "Изменить данные о имени фамилии и отчестве";
    }
    private final ConsoleUI consoleUI;

    public EditNameButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        System.out.println("Введите новое Ф.И.О.: ");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("EditingName", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");

    }

    @Override
    public String toString() {
        return text;
    }
}
