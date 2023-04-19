package view.command;

import java.util.LinkedHashMap;

import view.ConsoleUI;

public class ChangeCurrentID extends Commands {
    private final String name = "change id";
    private final String help = "change id:`id` - переход к редактированию человека\n";

    public ChangeCurrentID(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        int id = 0;
        try {
            id = Integer.parseInt(map.get(this.name));
        } catch (Exception e) {
            this.getConsole().print("incorrect format `id`");
            return;
        }

        Boolean id_exist = this.getConsole()
                .getPresenter()
                .commandExistPersonByID(id);

        String cursor = this.getConsole().getDefault_cursor();
        if (id_exist) {
            cursor = map.get(this.name) + " " + this.getConsole().getDefault_cursor();
        } else {
            this.getConsole().print("this id: " + id + " don`t exist!");
        }

        this.getConsole().setCurrent_id(id);
        this.getConsole().setCursor(cursor);
        this.getConsole()
                .getPresenter()
                .commandFullPersonInfo(map.get(this.name));
    }

}
