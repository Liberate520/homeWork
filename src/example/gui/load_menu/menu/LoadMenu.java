package org.example.gui.load_menu.menu;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.SMenu;
import org.example.gui.load_menu.buttons.AddTreeButton;

import org.example.gui.load_menu.buttons.LoadTreeButton;

import java.util.ArrayList;

public class LoadMenu extends SMenu {
    private final ConsoleUI consoleUI;
    private final ArrayList<SButton> buttons = new ArrayList <>();

    public LoadMenu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        addButton();
    }

    public ArrayList<SButton> getButtons() {
        return buttons;
    }

    @Override
    public void addButton() {
         buttons.add(new LoadTreeButton(consoleUI));
         buttons.add(new AddTreeButton(consoleUI));
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
