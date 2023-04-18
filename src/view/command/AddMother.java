package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddMother extends Commands {
    private final String name = "add mother";
    private final String help = "add mother:1679946500.mother.1679946400 - Добавить мать, дети добавляются автоматически к родителям\n";

    public AddMother(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }
    
    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id, id_parent;
        try {
            id = Integer.parseInt(map.get(this.name));
            id_parent = Integer.parseInt(map.get("mother"));
        } catch (Exception e) {
            return;
        }
        this.getConsole()
                .getPresenter()
                .commandEditPerson(id, "mother", id_parent);
    }
    
}
