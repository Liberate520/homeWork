package family_Tree.view;

import family_Tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GenerateTree(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new AddParent(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortById(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new PrintTree(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String getMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие :\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}