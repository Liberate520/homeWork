package tree.familyTree.presenter;

import tree.Service;
import tree.human.Gender;

public class Presenter {
    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public void addHuman(String name, Gender gender) {
        service.addHuman(name, gender );
    }
    public void getFamilyTree() {

        System.out.println(service.toString());
    }
    void sortByName() {
        service.sortByName();
    }
    void sortByChild() {
        service.sortByChild();
    }
    public void findHuman(String name) {
        System.out.println(service.findHuman(name).toString());
    }
}
