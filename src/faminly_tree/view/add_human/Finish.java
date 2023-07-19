package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;

public class Finish extends HumanData{

    public Finish(ConsoleUI console) {
        super(console);
        description = "Завершить ввод данных и добавить человека";
    }

    @Override
    public void execute() {
        console.finishAddHuman();
    }
}
