package view.comands;

import view.Console;

public class SearchByName extends Command {
    public SearchByName(Console console) {
        super(console);

    }

    public String getDescription(){
        return "Поиск по имени";
    }

    public void execute(){
        console.SearchBuName();
    }
}
