package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.View;

public class OrderByAge extends Command{

    public OrderByAge(View view) {
        super(view, "Показать всех членов семьи отсортированных по возрасту");
    }

    @Override
    public void execute() {
        view.getSortedByAge();
    }
}
