package view.commands;

import view.Console;

import java.io.IOException;

public class SaveData extends Command {

    public SaveData(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Сохранить текущее состояние";
    }

    @Override
    public void execute() throws IOException {
        getConsole().saveData();
    }

}
