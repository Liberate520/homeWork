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
     public void addParent(String child, String parent) {
        service.addParent(child, parent);
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

    public void findHuman(String name) {
        service.findHuman(name);
    }

    public void removeHumanFromTree(String name) {
        service.removeHumanFromTree(name);
    }

    public void saveFile() throws IOException {
        service.saveObject();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        service.loadFile();
    }
}
