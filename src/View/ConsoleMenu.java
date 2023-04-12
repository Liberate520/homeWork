package Homeworks.OOPHW.OOP_homeWork_L5.src.View;

import java.util.ArrayList;
import java.util.List;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter.Presenter;

public class ConsoleMenu implements Menu{
    List<String> mainMenu;

    public ConsoleMenu() {
        mainMenu = new ArrayList<>();
        mainMenu.add(new Commands().getAllNotes());
        mainMenu.add(new Commands().getAddNote());
        mainMenu.add(new Commands().getExit());
    }

    @Override
    public void printMenu() {
        System.out.println();
        System.out.println("*** Выберите действие ===>");
        for (int i = 0; i < sizeMenu(); i++) {
            System.out.printf("%d. %s\n", i + 1, mainMenu.get(i));
        }
    }

    @Override
    public int sizeMenu() {
        return mainMenu.size();
    }
    
    @Override
    public void perform(int issue, Presenter presenter) {
        Commands command = new Commands();
        if (issue <= mainMenu.size()) command.exec(mainMenu.get(issue - 1), presenter);
        else System.out.println("Выбор некорректен. Попробуйте ещё раз!");
    }
}
