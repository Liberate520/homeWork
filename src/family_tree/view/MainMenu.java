package family_tree.view;

import family_tree.view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandsList;

    public MainMenu(Console console) {
        commandsList = new ArrayList<>();
        commandsList.add(new SortById(console));
        commandsList.add(new SortByDateOfBirth(console));
        commandsList.add(new SortByAge(console));
        commandsList.add(new GetAllFamilyInfo(console));
        commandsList.add(new Finish(console));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandsList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandsList.size();
    }
}
