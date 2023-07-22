package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;

public class Death extends DateBirthOrDeath{
    public Death(ConsoleUI console, Container container) {
        super(console, container);
        description = "Дата смерти";
    }

    @Override
    public void execute() {
        super.execute();
        container.setDeath(value);
    }

}
