package UI.Commands;

import UI.Console;

import java.io.IOException;

public class SaveChanges extends Command{

    public SaveChanges(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сохранить изменения";
    }

    @Override
    public void execute() {
        try {
            getConsole().saveChanges();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
