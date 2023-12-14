package FamilyTree_homework.view;


import FamilyTree_homework.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(Console console) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new SortByName(console));
        commands.add(new SortByAge(console));
        commands.add(new GetHumanList(console));
        commands.add(new Save(console));
        commands.add(new Load(console));
        commands.add(new Finish(console));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public  int size(){
        return commands.size();
    }
}
