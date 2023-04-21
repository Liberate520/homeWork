package ui.Commands.FamilyCommands;

import javax.swing.text.View;

import ui.Console;
import ui.Commands.Command;

public class ReadFamilyFromFile extends Command {

    public ReadFamilyFromFile(Console console) {
        super(console);
        description = "Загрузить состав семьи из файла";
    }

    @Override
    public void execute() {
        console.readFamilyFromFile();
    }

}
