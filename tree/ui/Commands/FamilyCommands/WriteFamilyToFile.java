package ui.Commands.FamilyCommands;

import ui.Console;
import ui.Commands.Command;

public class WriteFamilyToFile extends Command {

    public WriteFamilyToFile(Console console) {
        super(console);
        description = "Запись состава семьи в файл";
    }

    @Override
    public void execute() {
        console.writeFamilyToFile();
    }

}
