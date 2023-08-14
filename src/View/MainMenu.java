package View;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.AEADBadTagException;

import View.Commands.*;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new SetWedding(consoleUI));
        commands.add(new SetDivorse(consoleUI));
        commands.add(new AddParents(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new GetInfo(consoleUI));
        commands.add(new Save(consoleUI));
        commands.add(new Load(consoleUI));
        commands.add(new Finish(consoleUI));
        System.out.println(commands.size());
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
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
