package org.example.gui.t_menu.button;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EditDateOfBirthButton extends SButton {
    private final Integer indexHuman;
    private final String text;
    {
        text = "Изменить данные о дате рождения";
    }
    private final ConsoleUI consoleUI;

    public EditDateOfBirthButton(ConsoleUI consoleUI, Integer indexHuman) {
        this.indexHuman = indexHuman;
        this.consoleUI = consoleUI;
    }

    @Override
    public void action() throws IOException {
        System.out.println("Введите дату в формате <<< |день|пробел|месяц|пробел|год| >>>");
        String input = consoleUI.getScanner().nextLine();
        consoleUI.getPresenter().setCommandFromView("dateB", input, indexHuman);
        consoleUI.setPrintList(consoleUI.getPresenter().getPrintList()); // обнавляет лист для печати после операции
        System.out.println("Данные измененны.");
    }

    @Override
    public String toString() {
        return text;
    }
}
