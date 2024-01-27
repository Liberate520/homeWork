package ru.gb.view.gender;


import ru.gb.model.treeItem.Gender;
import ru.gb.view.ConsoleUI;

public class Male extends GenderInterface {
    public Male(ConsoleUI console) {
        super("Мужской", console);
    }

    @Override
    public Gender execute() {
        return getView().strToGender("Male");
    }
}
