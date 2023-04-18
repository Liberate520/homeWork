package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddSexFemale extends Commands {
    private final String name = "add sex female";
    private final String help = "add sex female:1679946500 - Добавить пол женский\n";

    public AddSexFemale(ConsoleUI console) {
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
                .commandAddSex(id,"female");
    }
    
}
