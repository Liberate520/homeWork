package src.UI.commands;


import src.FamilyTree.Person;
import src.UI.Console;

import java.util.ArrayList;

public class YearsOfTheReignOfPersons extends Command {

    private ArrayList<Person> family;

    public YearsOfTheReignOfPersons(Console console) {
        super(console);
        this.family = family;
    }


    @Override
    public String description() {
        return "Print the Years of the reign of persons";
    }

    @Override
    public void execute() {
        super.getConsole().yearsOfTheReignOfPersons();
    }
}
