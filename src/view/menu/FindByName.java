package view.menu;

import view.Console;

public class FindByName implements Command{
    public Console console;
    public String name;

    public FindByName(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Найти запись по имени";
    }

    @Override
    public void execute() {
        console.findByName();
    }
}
