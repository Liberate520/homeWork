package ui.optionConsole;

import ui.Console;

public class AddUnit extends Option {

    public AddUnit(Console console) {
        super(console);
        setDescription("Добавить члена семьи");
    }

    @Override
    public void execute() {
        super.getConsole().addUnit();
    }
}
