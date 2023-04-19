package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddSexMale extends Commands {
    private final String name = "add sex male";
    private final String help = "add sex male - Добавить пол мужской, к текущему `id`\n";

    public AddSexMale(ConsoleUI console) {
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
                .commandAddSex(id, "male");
    }

}
