package org.example.gui.main_menu.menu;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.SMenu;
import org.example.gui.main_menu.buttons.*;

import java.util.ArrayList;

public class MainMenu extends SMenu {

    private final ConsoleUI consoleUI;
    private final ArrayList <SButton> buttons = new ArrayList <>();

    public MainMenu(ConsoleUI consoleUI) {
       this.consoleUI = consoleUI;
       addButton();
    }



    public ArrayList<SButton> getButtons() {
        return buttons;
    }

    @Override
    public void addButton() {
        buttons.add(new PrintListMainButton(consoleUI));
        buttons.add(new AddHumanMainButton(consoleUI));
        buttons.add(new AddEditDataMainButton(consoleUI));
        buttons.add(new RemoveHumanMainButton(consoleUI));
        buttons.add(new SaveTreeMainButton(consoleUI));

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < buttons.size(); i++) {
            res.append(String.format("%d - %s\n", i + 1, buttons.get(i).toString()));
        }
    return res.toString();
    }
}
