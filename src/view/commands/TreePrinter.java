package view.commands;

import model.Organisms.Person.Person;
import presenter.Presenter;

public class TreePrinter implements Command{
    String description = "Watch the tree";
    public void start(Presenter presenter) {
        int i = 1;
        for(Person person: presenter.getTree()){
            System.out.println(i + ". " + person);
            i++;
        }
        System.out.println();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
