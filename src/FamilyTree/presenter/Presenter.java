package FamilyTree.presenter;

import FamilyTree.model.Service.Service;
import FamilyTree.view.View;

public class Presenter<T> {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void add(T human) {
        service.addHuman(human);
    }

    public void getHumanList() {
        service.getHumanInfo();
    }

    public void sortbyname() {
        service.sortByName();
    }

    public void sortbyage() {
        service.sortByAge();
    }
}
