package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;
import com.pamihnenkov.view.View;

public class ShowAllMembers extends Command{

    public ShowAllMembers(View view) {
        super(view, "Показать всех членов семьи");
    }

    @Override
    public void execute() {
        view.showAllMembers();
    }
}
