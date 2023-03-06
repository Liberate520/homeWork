package HW01.ui.commands;

import HW01.ui.Console;

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
