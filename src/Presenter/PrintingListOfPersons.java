package src.Presenter;

import src.FamilyTree.Person;

import java.util.ArrayList;

public class PrintingListOfPersons extends Command{
    private ArrayList<Person> family;

    public PrintingListOfPersons(Presenter presenter, ArrayList<Person> family) {
        super(presenter);
        this.family = family;
    }

    @Override
    public String description() {
        return "Prints the list of persons of the family tree";
    }

    @Override
    public void execute() {

    }
}
