package src.UI.commands;

import src.UI.Console;


public class PrintingListOfPersons extends Command {

    public PrintingListOfPersons(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Prints the list of persons of the family tree";
    }

    @Override
    public void execute() {
        super.getConsole().printingListOfPersons();
    }
}
