package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class New extends Commands {
    private final String name = "new";
    private final String help = "new:`имя` - Добавить нового человека(создает и присваевает id)\n";

    public New(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map){
        this.getConsole()
                .getPresenter()
                .commandAddNewPerson(map.get(this.name));
    }

}
