package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI ui) {
        commands = new ArrayList<>();
        commands.add(new PrintAll(ui));
        commands.add(new AddNewMember(ui));
        commands.add(new PrintDetail(ui));
        commands.add(new EditMember(ui));
        commands.add(new CommandSave(ui));
        commands.add(new CommandQuit(ui));
    }

    public String getMenu() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1);
            builder.append(". ");
            builder.append(commands.get(i).getDescription());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public int getSize(){
        return commands.size();
    }
}
