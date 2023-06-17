package Views;

import java.util.ArrayList;
import java.util.List;

import Views.Commands.Command;
import Views.Commands.CommandAdd;
import Views.Commands.CommandQuit;
import Views.Commands.CommandRemove;
import Views.Commands.CommandSave;
import Views.Commands.CommandShow;
import Views.Commands.CommandUpdate;

public class Menu {
    private List<Command> commands;
    private final String format = "\t==> %d. %s\r\n";
    
    public Menu(Executable executable){
        commands = new ArrayList<>();
        commands.add(new CommandShow(executable));
        commands.add(new CommandAdd(executable));
        commands.add(new CommandRemove(executable));
        commands.add(new CommandUpdate(executable));
        commands.add(new CommandSave(executable));
        commands.add(new CommandQuit(executable));
    }
    
    public void execute(int index){
        commands.get(index).execute();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int index = 1;
        builder.append("\n===================================================\n");       
        for (Command command : commands) {
            builder.append(String.format(format, index++, command.getInfo()));
        }
        builder.append("===================================================\n");        
        return builder.toString();
    }

}
