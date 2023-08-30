package view.comands;

import view.Console;

public class GetSortByName extends Command {


    public GetSortByName(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Отсортировать по имени";
    }

    public void execute() {
        console.GetSortByName();
    }
}

