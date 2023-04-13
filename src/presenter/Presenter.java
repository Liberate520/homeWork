package presenter;

import familyTreeApi.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addFamilyTree(String member, String name) {
        return service.addFamilyTree(member, name);
    }

    public boolean addMember(String member, String name) {
        return service.addFamilyTree(member, name);
    }

    public void editFTree() {
        service.editFTree();
    }

    public boolean isFindFamilyTree(String nameFTree) {
        return service.isFindFamilyTree(nameFTree);
    }

    public void load(String fileName) {
        service = new Service(service.read(fileName));
    }

    public void save(String fileName){
        service.save(fileName);
    }

    public void printInfo() {
        view.print(service.printInfo());
    }

    public void printFTrees() {
        view.print(service.printTrees());
    }
}
