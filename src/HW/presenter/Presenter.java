package HW.presenter;

import HW.model.ServiceHuman;
import HW.model.human.Human;
import HW.model.tree.FamilyTree;
import java.util.List;

public class Presenter {
    private ServiceHuman serviceHuman;

    public Presenter(FamilyTree<Human> tree) {
        this.serviceHuman = new ServiceHuman(tree);
    }

    public void addNote(String name, String surname, String sex, String dateOfBirth, String dateOfDeath, String fatherName, String fatherSurname, String motherName, String motherSurname) {
        serviceHuman.addNote(name, surname, sex, dateOfBirth, dateOfDeath, fatherName, fatherSurname, motherName, motherSurname);
    }

    public String getNote(String name, String surname) {
        return serviceHuman.getNote(name, surname);
    }

    public List<String> getAllNote() {
        return serviceHuman.getAllNotes();
    }

    public void doSave() {
        serviceHuman.doSave();
    }

    public void doRecover() {
        serviceHuman.doRecover();
    }
}
