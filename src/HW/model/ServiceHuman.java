package HW.model;

import HW.model.human.Human;
import HW.model.human.enumerate.Sex;
import HW.model.tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public class ServiceHuman {
   FamilyTree<Human> tree;

    public ServiceHuman(FamilyTree<Human> tree) {
        this.tree = tree;
    }

    public List<Human> getAllNotes() {
        return tree.getAllNotes();
    }
    public Human getNote(String name, String surname){
        return tree.findPerson(name, surname);
    }
    public void addNote (String name, String surname){
        tree.addPerson(new Human(name, surname));
    }

}
