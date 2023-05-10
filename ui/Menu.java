package ui;

import java.util.ArrayList;
import java.util.List;

import ui.commands.AddRecords;
import ui.commands.Command;
import ui.commands.Exit;
import ui.commands.PrintTree;
import ui.commands.ReadTree;
import ui.commands.SaveTree;
import ui.commands.Search;
import ui.commands.SortBirthDate;
import ui.commands.SortByName;

public class Menu {
    
    private List<Command> commands;

    public Menu (View view){
        this.commands= new ArrayList<>();
        commands.add(new AddRecords(view));
        commands.add(new Search(view));
        commands.add(new SortBirthDate(view));
        commands.add(new SortByName(view));
        commands.add(new ReadTree(view));
        commands.add(new SaveTree(view));
        commands.add(new PrintTree(view));
        commands.add(new Exit(view));

    }

    public void execute(int number){
        commands.get(number-1).execute();

    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
