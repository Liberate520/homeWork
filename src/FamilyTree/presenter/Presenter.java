package FamilyTree.presenter;

import FamilyTree.view.View;

public class Presenter {
    private View view;
//    private Service service;
    public Presenter(View view) {
        this.view = view;
//        service = new FamilyTreeService();

    }

    public void addHuman(String name, int age) {
//        service.addHuman(name, age);
    }
}
