package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddSexFemale extends Commands {
    private final String name = "add sex female";
    private final String help = "add sex female - Добавить пол женский к текущему `id`\n";

    public AddSexFemale(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id = this.getConsole().getCurrent_id();
        if (id == 0) {
            this.getConsole().print("For editing: Need change current `id`");
            return;
        }

        this.getConsole()
                .getPresenter()
                .commandAddSex(id, "female");
    }

}
