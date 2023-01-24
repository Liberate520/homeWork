package commands;

import ui.Console;

public class Save implements Commands {

    Console console;

    public Save(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {

        console.getPresenter().saveCalendar();

    }

    @Override
    public String description() {
        return "Сохранить файл";
    }
}