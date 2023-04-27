package view.commands;

import view.Console;

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
