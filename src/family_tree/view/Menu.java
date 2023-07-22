package family_tree.view;

import family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;

    public Menu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new AddFamilyMember(consoleUI));
        commands.add(new GetFamilyInfo(consoleUI));
        commands.add(new GetFamilyMemberInfo(consoleUI));
        commands.add(new SaveFamily(consoleUI));
        commands.add(new LoadFamily(consoleUI));
        commands.add(new SetDateOfDeath(consoleUI));
        commands.add(new SetHusbandWife(consoleUI));
        commands.add(new SetParentChild(consoleUI));
        commands.add(new ShowSiblings(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new UnsetHusbandWife(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String display(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        commands.get(choice - 1).execute();
    }

    public int getSize() {
        return commands.size();
    }
}
