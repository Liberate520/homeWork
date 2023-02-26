package HW01.ui.commands;

import HW01.ui.Console;

public class TestTree extends Command {

    public TestTree(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Заполнить дерево тестовыми записями";
    }

    @Override
    public void execute() {
        getConsole().testTree();
    }

}
