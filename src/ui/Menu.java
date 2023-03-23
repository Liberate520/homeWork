package ui;

import ui.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console){
        this.console=console;
        commands = new ArrayList<>();
        commands.add(new TestNotes(console));
        commands.add(new LoadData(console));
        commands.add(new TestNotes(console));
        commands.add(new SaveData(console));
        commands.add(new AddNotes(console));
        commands.add(new PrintNotes(console));
        commands.add(new DeleteNotes(console));
        commands.add(new Exit(console));
    }
    void execute(int number) throws Exception {
        Option option = commands.get(number);
        option.execute();
    }
    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 1; i < commands.size() ; i++) {
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public Integer getMenuRowsValue(){
        return commands.size();
    }
}
