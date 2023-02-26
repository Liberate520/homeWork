package HW01.ui.commands;

import HW01.ui.Console;

public class PrintTree extends Command {

    public PrintTree(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Вывести на экран все записи";
    }

    @Override
    public void execute() {
        getConsole().printTree();
    }

}
