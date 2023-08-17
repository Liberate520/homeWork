package ru.gb.fam_tree.view;

import ru.gb.fam_tree.view.comands.*;

import java.util.ArrayList;
import java.util.List;

public class EditMenu {
    List<EditMenuComand> emcommandList;

    public EditMenu(ConsoleUI consoleUI){
        emcommandList = new ArrayList<>();
        emcommandList.add(new ChangeName(consoleUI));
        emcommandList.add(new SetGender(consoleUI));
        emcommandList.add(new SetBirthDate(consoleUI));
        emcommandList.add(new SetDeathDate(consoleUI));
        emcommandList.add(new SetFather(consoleUI));
        emcommandList.add(new SetMother(consoleUI));
        emcommandList.add(new SetSpouce(consoleUI));
        emcommandList.add(new DeleteSpouce(consoleUI));
        emcommandList.add(new SetChild(consoleUI));
        emcommandList.add(new FinishEditMenu(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < emcommandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(emcommandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice, long id){
        EditMenuComand emcommand = emcommandList.get(choice-1);
        emcommand.execute(id);
    }

    public int getSize(){
        return emcommandList.size();
    }
}
