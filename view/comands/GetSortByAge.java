package view.comands;

import view.Console;

public class GetSortByAge extends Command{
    public GetSortByAge(Console console) {
        super(console);
    }

    public String getDescription() {
        return "Отсортировать по возрасту";
    }

    public void execute() {
        console.GetSortByAge();
    }
}
