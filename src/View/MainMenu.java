package View;

import View.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddHumanWithParents(consoleUI));
        commandList.add(new GetInfoFamily(consoleUI));
        commandList.add(new FindById(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new MakeMarriage(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            st.append(i + 1);
            st.append(". ");
            st.append(commandList.get(i).getDescription());
            st.append("\n");
        }
        return st.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
