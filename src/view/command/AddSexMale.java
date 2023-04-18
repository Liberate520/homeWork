package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddSexMale extends Commands {
    private final String name = "add sex male";
    private final String help = "add sex male:1679946500 - Добавить пол мужской\n";

    public AddSexMale(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id;
        try {
            id = Integer.parseInt(map.get(this.name));
        } catch (Exception e) {
            return;
        }
        this.getConsole()
                .getPresenter()
                .commandAddSex(id,"male");
    }
    
}
