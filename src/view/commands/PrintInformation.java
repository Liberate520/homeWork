package view.commands;

import view.Console;

public class PrintInformation extends Command {

    public PrintInformation(Console console) {
        super(console);
        description = "Вывести информацию";

    }

    public void execute() {
        console.printInformation();
    }
    
}
