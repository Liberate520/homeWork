package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;
import com.pamihnenkov.view.View;

public class GetBrothersAndSister extends Command {
    public GetBrothersAndSister(ConsoleUI view) {
        super(view, "Показать братьев и сестер для человека");
    }

    @Override
    public void execute() {
        view.getBrothersAndSister();
    }
}
