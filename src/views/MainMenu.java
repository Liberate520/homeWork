package views;

import java.util.ArrayList;
import java.util.List;

import views.commands.Command;
import views.commands.CommandAddNewMember;
import views.commands.CommandEditMember;
import views.commands.CommandQuit;
import views.commands.CommandSave;
import views.commands.CommandPrintAll;
import views.commands.CommandPrintDetail;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI ui) {
        commands = new ArrayList<>();
        commands.add(new CommandPrintAll(ui));
        commands.add(new CommandAddNewMember(ui));
        commands.add(new CommandPrintDetail(ui));
        commands.add(new CommandEditMember(ui));
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
