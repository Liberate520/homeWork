package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;
import com.pamihnenkov.view.View;

public class AddFamilyMember extends Command {

    public AddFamilyMember(View view) {
        super(view,"Добавить нового члена семейства");
    }

    public void execute(){
        view.addNewMember();
    }
}
