package Homework25_2.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Homework25_2.UI.commands.AddNote;
import Homework25_2.UI.commands.DeleteNote;
import Homework25_2.UI.commands.Exit;
import Homework25_2.UI.commands.Option;
import Homework25_2.UI.commands.ShowNote;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console){
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new ShowNote(console));
        commands.add(new AddNote(console));
        commands.add(new DeleteNote(console));
        commands.add(new Exit(console));
    }

    void execute (int num) throws IOException, ClassNotFoundException{
        Option option = commands.get(num);
        option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("-----Главное меню------\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).descriptions());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Integer getMenuRowsValue(){
        return commands.size();
    }
}
