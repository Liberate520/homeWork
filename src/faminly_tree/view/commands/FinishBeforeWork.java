package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class FinishBeforeWork extends Command{
    public FinishBeforeWork(ConsoleUI console) {
        super(console);
        description = "Завершение работы";
    }

    @Override
    public void execute() {
        console.finishBeforeWork();
    }
}
