package java_oop_homeWork.src.presenter;

import java_oop_homeWork.src.model.Service;
import java_oop_homeWork.src.ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addParent(int idKinsman, String firstName, String lastName, int sex) {
        service.addParent(idKinsman, firstName, lastName, sex);
    }

    public void addChild(int idKinsman, String firstName, String lastName, int sex) {
        service.addChild(idKinsman, firstName, lastName, sex);
    }

    public void getFamilyTree() throws NullPointerException {
        view.print(service.getFamilyTree());
    }

    public void getNameActiveFamily() throws NullPointerException {
        view.print(service.getActiveNameFamily());
    }

    public void createFamilyTree(String family, String firstName, String lastName, int sex) {
        service.createFamilyTree(family, firstName, lastName, sex);
    }

    public void getAllTrees() {
        view.print(service.getAllTrees());
    }

    public void selectFamilyTree(String family) throws NullPointerException {
        service.selectFamilyTree(family);
    }

    public boolean isKinsman(int id) {
        return service.isKinsman(id);
    }
}
