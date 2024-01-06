package ru.gb.view.gender;

import ru.gb.model.treeItem.Gender;
import ru.gb.view.ConsoleUI;

public class Female extends GenderInterface {
    public Female(ConsoleUI console) {
        super("Женский", console);
    }

    @Override
    public Gender execute() {
        return getView().strToGender("Female");
    }
}