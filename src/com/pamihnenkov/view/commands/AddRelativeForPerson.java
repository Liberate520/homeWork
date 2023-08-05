package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;
import com.pamihnenkov.view.View;

public class AddRelativeForPerson extends Command {
    public AddRelativeForPerson(ConsoleUI view) {
        super(view, "Добавить связь между членами дерева");
    }

    @Override
    public void execute() {
        view.addRelativeForPerson();
    }
}
