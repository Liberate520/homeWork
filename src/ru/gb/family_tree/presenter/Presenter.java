package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.saveload.LoadFileHandler;
import ru.gb.family_tree.model.saveload.Reading;
import ru.gb.family_tree.model.saveload.SaveFileHandler;
import ru.gb.family_tree.model.saveload.Writing;
import ru.gb.family_tree.model.services.HumanTreeService;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.View;
import java.util.HashMap;

public class Presenter {
    private final View view;
    private final HumanTreeService service;

    public Presenter(View view) {
        this.view = view;
        service   = new HumanTreeService();
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
        Reading<FamilyTree<Human>> handler = new LoadFileHandler<>(fileName);
        view.print(service.importTreeFromObjectFile(handler));
    }

    public void exportTree(String fileName) {
        Writing handler = new SaveFileHandler(fileName);
        view.print(service.exportTreeToObjectFile(handler));
    }

    public int getTreeSize() {
        return service.getTreeSize();
    }
}
