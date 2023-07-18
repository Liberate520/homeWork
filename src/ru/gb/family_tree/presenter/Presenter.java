package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.services.TreeService;
import ru.gb.family_tree.view.View;
import java.util.HashMap;

public class Presenter {
    private final View view;
    private final TreeService service;

    public Presenter(View view) {
        this.view = view;
        service   = new TreeService();
    }

    public void addMember(HashMap<String, String> data) {
        view.print(service.addMember(data));
    }

    public void getMembers() {
        view.print(service.getMembers());
    }

    public void sortByName() {
        service.sortByName();
        view.print(service.getMembers());
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.print(service.getMembers());
    }

    public void importTree(String fileName) {
        view.print(service.importTree(fileName));
    }

    public void exportTree(String fileName) {
        view.print(service.exportTree(fileName));
    }

    public int getTreeSize() {
        return service.getTreeSize();
    }
}
