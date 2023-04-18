package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddFather extends Commands {
    private final String name = "add father";
    private final String help = "add father:1679946500.father.1679946400 - Добавить отца, дети добавляются автоматически к родителям\n";

    public AddFather(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id, id_parent;
        try {
            id = Integer.parseInt(map.get(this.name));
            id_parent = Integer.parseInt(map.get("father"));
        } catch (Exception e) {
            return;
        }
        this.getConsole()
                .getPresenter()
                .commandEditPerson(id, "father", id_parent);
    }

    
}
