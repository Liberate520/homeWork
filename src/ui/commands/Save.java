package ui.commands;

import ui.Console;

import java.io.IOException;

public class Save extends Command {
    public Save(Console console) {
        super(console);
        description = "Сохранить дерево в файл";
    }

    @Override
    public void execute() {
        console.save();
    }
}
