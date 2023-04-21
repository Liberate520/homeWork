package ui.Commands;

import ui.Console;

public class FindInfo extends Command {

    public FindInfo(Console console) {
        super(console);
        description = "Найти информацию в семейном деореве";
    }

    @Override
    public void execute() {
        // console.getInfo();
    }

}
