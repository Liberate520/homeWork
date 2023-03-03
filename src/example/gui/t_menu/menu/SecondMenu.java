package org.example.gui.t_menu.menu;

import org.example.gui.ConsoleUI;
import org.example.gui.SButton;
import org.example.gui.SMenu;
import org.example.gui.t_menu.button.*;

import java.util.ArrayList;


public class SecondMenu extends SMenu {
    private final ArrayList<SButton> buttons = new ArrayList <>();
    private final ConsoleUI consoleUI;
    private final Integer indexHuman;


    public SecondMenu(ConsoleUI consoleUI, Integer indexHuman) {
        this.consoleUI = consoleUI;
        this.indexHuman = indexHuman;
        addButton();
    }

    public ArrayList<SButton> getButtons() {
        return buttons;
    }

    @Override
    public void addButton() {
    buttons.add(new EditNameButton(consoleUI, indexHuman));
    buttons.add(new EditGenderButton(consoleUI, indexHuman));
    buttons.add(new EditDateOfBirthButton(consoleUI, indexHuman));
    buttons.add(new EditTheDateOfDeathButton(consoleUI, indexHuman));
    buttons.add(new EditMotherButton(consoleUI, indexHuman));
    buttons.add(new EditFatherButton(consoleUI, indexHuman));
    buttons.add(new EditChildrenButton(consoleUI, indexHuman));
    buttons.add(new EditBrothersAndSistersButton(consoleUI, indexHuman));
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
