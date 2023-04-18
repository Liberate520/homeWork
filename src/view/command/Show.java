package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class Show extends Commands {
    private final String name = "show";
    private final String help = "show: - показывает всех участников дерева\n";

    public Show(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map){
        this.getConsole()
                .getPresenter()
                .commandShow();
    }

}
