package HW.presenter;

import HW.model.ServiceHuman;
import HW.model.human.Human;
import HW.model.human.enumerate.Sex;
import HW.model.tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    ServiceHuman serviceHuman;

    public Presenter(FamilyTree<Human> tree) {
        this.serviceHuman = new ServiceHuman(tree);
    }

    public void addNote(String name, String surname) {
        serviceHuman.addNote(name, surname);
    }

    public Human getNote(String name, String surname) {
        return serviceHuman.getNote(name, surname);
    }

    public List<Human> getAllNote() {
        return serviceHuman.getAllNotes();
    }
}
