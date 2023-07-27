package view.commands;

import view.Console;

public class WriteFile extends Command{

    
    public WriteFile(Console console) {
        super(console);
        description = "Записать в файл";

    }
    

    @Override
    public void execute() {
        console.writeFile();
    }
    
}
