package ru.gb.family_tree_homework.UI;

import ru.gb.family_tree_homework.UI.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new AddFamilyMember(consoleUI));
        commands.add(new GetByName(consoleUI));
        commands.add(new GetFamilyTreeInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SetParent(consoleUI));
        commands.add(new SetChild(consoleUI));
        commands.add(new SetWedding(consoleUI));
        commands.add(new SetDivorce(consoleUI));
        commands.add(new Remove(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new LoadTree(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1)
                    .append(".")
                    .append(" ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commands.size();
    }
}
