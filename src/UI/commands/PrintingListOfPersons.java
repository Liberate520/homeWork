package src.UI.commands;

import src.FamilyTree.Person;
import src.UI.Console;

import java.util.ArrayList;

public class PrintingListOfPersons extends Command {
    private ArrayList<Person> family;

    public PrintingListOfPersons(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Prints the list of persons of the family tree";
    }

    @Override
    public void execute() {
        System.out.println("the list of persons....");
    }
}
