package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;

public class ShowAllMembers extends Command{

    public ShowAllMembers(ConsoleUI view) {
        super(view, "Показать всех членов семьи");
    }

    @Override
    public void execute() {
        view.showAllMembers();
    }
}
