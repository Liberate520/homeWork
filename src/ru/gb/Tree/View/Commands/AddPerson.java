package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class AddPerson extends Command{


    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить нового члена семьи");
    }
    public void execute(){
        consoleUI.addPerson();
    }
}
