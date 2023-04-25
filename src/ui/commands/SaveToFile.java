package ui.commands;

import ui.Console;

public class SaveToFile extends Command {
    public SaveToFile(Console console){
        super(console);
    }
    public String getDescription(){
        return "Сохранить дерево в файл";
    }

    public void execute(){
        getConsole().saveToFile();
    }
}
