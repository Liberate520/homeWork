package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.View;

public class OrderByBirthDate extends Command{

    public OrderByBirthDate(View view) {
        super(view, "Показать всех членов семьи отсортированных по дате рождения");
    }

    @Override
    public void execute() {
        view.getSortedByBirthdate();
    }
}
