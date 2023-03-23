package ui.commands;

import ui.Console;

import java.io.IOException;

public class SaveData extends Command {

    public SaveData(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить заметки";
    }

    @Override
    public void execute() throws Exception {
        getConsole().saveData();
    }
}
