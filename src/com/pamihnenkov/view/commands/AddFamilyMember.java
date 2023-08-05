package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;

public class AddFamilyMember extends Command {

    public AddFamilyMember(ConsoleUI view) {
        super(view,"Добавить нового члена семейства");
    }

    public void execute(){

        view.addNewMember();
    }
}
