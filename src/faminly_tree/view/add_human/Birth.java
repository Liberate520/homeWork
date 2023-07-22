package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;
//сделать через декоратор
public class Birth extends DateBirthOrDeath{
    public Birth(ConsoleUI console, Container container) {
        super(console, container);
        description = "Дата рождения";
    }
    @Override
    public void execute() {
        super.execute();
        container.setBirth(value);
    }
}
