package org.example.gui.main_menu.buttons;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveTreeMainButton extends SButton {
    private final String text;
    {
        text = "Сохранить изменения в дереве";
    }
    private final ConsoleUI consoleUI;

    public SaveTreeMainButton(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }


    @Override
    public void action() throws IOException {
        consoleUI.getPresenter().setCommandFromView("save", "", -1);

    }

    @Override
    public String toString() {
        return text;
    }
}
