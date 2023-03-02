package src.Presenter;


import src.FamilyTree.Person;

import java.util.ArrayList;

public class YearsOfTheReignOfPersons extends Command{

    private ArrayList<Person> family;

    public YearsOfTheReignOfPersons(Presenter presenter, ArrayList<Person> family) {
        super(presenter);
        this.family = family;
    }


    @Override
    public String description() {
        return "Print the Years of the reign of persons";
    }

    @Override
    public void execute() {
//        FamilyTree<Person> family = SavingFT.restoreFromFile();
//        System.out.println(family.sortByYearOfReigh());
        System.out.println("method 2");
    }
}
