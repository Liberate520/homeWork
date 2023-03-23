package ui.commands;

import ui.Console;

public class TestNotes extends Command{


    public TestNotes(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Заполнить блокнот тестовыми заметками";
    }

    @Override
    public void execute() {
        getConsole().myNotes();
    }
}
