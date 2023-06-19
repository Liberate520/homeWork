package Views;

import java.util.ArrayList;
import java.util.List;

import Views.Commands.Command;
import Views.Commands.CommandShow;
import Views.Commands.CommandRead;
import Views.Commands.CommandAdd;
import Views.Commands.CommandUpdate;
import Views.Commands.CommandRemove;
import Views.Commands.CommandClear;
import Views.Commands.CommandHelp;
import Views.Commands.CommandSave;
import Views.Commands.CommandQuit;

/** основное меню */
public class Menu {
    private List<Command> commands;
    private final String format = "-> %d. %s\r\n";
    
    public Menu(Executable executable){
        commands = new ArrayList<>();
        commands.add(new CommandShow(executable));
        commands.add(new CommandRead(executable));
        commands.add(new CommandAdd(executable));
        commands.add(new CommandRemove(executable));
        commands.add(new CommandUpdate(executable));
        commands.add(new CommandClear(executable));
        commands.add(new CommandHelp(executable));
        commands.add(new CommandSave(executable));
        commands.add(new CommandQuit(executable));
    }
    /** получить количество пунктов меню */
    public int getSize(){
        return commands.size();
    }

    /** выполнить действие */
    public void execute(int index){
        commands.get(index).execute();
    }

    /** строковое представление меню */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int index = 1;      
        for (Command command : commands) {
            builder.append(String.format(format, index++, command.getInfo()));
        }            
        return builder.toString();
    }

    /** помощь */
    public String getHelp(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            builder.append(commands.get(i).getHelp(i+1)+ "\n");
        }
        return builder.toString();
    }
}
