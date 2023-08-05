package com.pamihnenkov.view;

import com.pamihnenkov.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI view) {
        this.commands = new ArrayList<>();
        commands.add(new ShowAllMembers(view));
        commands.add(new AddFamilyMember(view));
        commands.add(new AddRelativeForPerson(view));
        commands.add(new GetBrothersAndSister(view));
        commands.add(new OrderByAge(view));
        commands.add(new OrderByBirthDate(view));
    }

    public String menu(){
        System.out.println();
        StringBuilder sb = new StringBuilder("Главное меню:\n");
        for (int i = 0; i < commands.size(); i ++){
            sb.append(i+1).append('.').append(commands.get(i).getDescription()).append('\n');
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commands.size();
    }
}
