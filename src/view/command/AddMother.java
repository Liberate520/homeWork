package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class AddMother extends Commands {
    private final String name = "add mother";
    private final String help = "add mother:`mother_id` - Добавить мать к текущему `id`, дети добавляются автоматически к родителям\n";

    public AddMother(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id = this.getConsole().getCurrent_id();
        int id_parent;
        if (id == 0) {
            this.getConsole().print("For editing: Need change current `id`");
            return;
        }

        try {
            id_parent = Integer.parseInt(map.get(this.name));
        } catch (Exception e) {
            this.getConsole().print("incorrect format `id`");
            return;
        }

        Boolean id_exist = this.getConsole()
                .getPresenter()
                .commandExistPersonByID(id_parent);

        if (!id_exist) {
            this.getConsole().print("this mother id: " + id_parent + " don`t exist!");
            return;
        }

        this.getConsole()
                .getPresenter()
                .commandEditPerson(id, "mother", id_parent);
    }

}
