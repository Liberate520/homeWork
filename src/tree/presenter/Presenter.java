package tree.presenter;

import tree.model.Service;
import tree.model.human.Gender;

import java.io.IOException;

public class Presenter {
    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public void addHuman(String name, Gender gender, String father, String mother) {
        service.addHuman(name, gender, father, mother);
    }
     public boolean addParent(String child, String parent) {
        return service.addParent(child, parent);
     }

    public void getFamilyTree() {
        service.printTree();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByChild() {
        service.sortByChild();
    }

    public String findHuman(String name) { return service.findHuman(name); }

    public boolean removeHumanFromTree(String name) { return service.removeHumanFromTree(name);
    }

    public void saveFile() throws IOException {
        service.saveObject();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        service.loadFile();
    }

    public boolean isDirectDescendant(String human1, String human2) {
        return service.isDirectDescendant(human1, human2);
    }
}
