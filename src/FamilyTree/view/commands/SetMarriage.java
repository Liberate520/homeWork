package FamilyTree.view.commands;

import FamilyTree.model.Person.Person;
import FamilyTree.view.View;

public class LinkPerson extends Command {
    private Person p1;
    private Person p2;

    public LinkPerson(View view, Person p1, Person p2) {
        super("Связать .", view);
        this.p1 = p1;
        this.p2 = p2;
    }

    public void execute(){ getView().linkPerson(p1, p2); }
}
