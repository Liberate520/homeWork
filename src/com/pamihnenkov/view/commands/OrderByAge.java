package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;

public class OrderByAge extends Command{

    public OrderByAge(ConsoleUI view) {
        super(view, "Показать всех членов семьи отсортированных по возрасту");
    }

    @Override
    public void execute() {
        view.getSortedByAge();
    }
}
