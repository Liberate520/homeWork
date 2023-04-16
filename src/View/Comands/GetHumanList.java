package View.Comands;

import View.Console;

public class GetHumanList extends Command {
    private Console console;

    public GetHumanList(Console console) {
        super(console);
    }

    public String description(){
        return "Получить список людей";
    }

    public void execute(){
        getConsole().getHumanList();
    }
}
