package presenter;

import treeAPI.Service;
import ui.View;

import java.util.Calendar;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addFamilyTree( String name) {
        return service.addFamilyTree(name);
    }

    public boolean addSample(String name, boolean isMale, Calendar bornDate) {
        return service.addSample(name, isMale, bornDate);
    }

    public boolean addChild(String parentName, String childName) {
        return service.addChild(parentName, childName);
    }

    public boolean addMarried(String married1Name, String married2Name, boolean isMarried) {
        return service.addMarried(married1Name, married2Name, isMarried);
    }

    public boolean isFindFamilyTree(String nameFTree) {
        return service.isFindFamilyTree(nameFTree);
    }

    public boolean load(String fileName) {
        service.read(fileName);
        return true;
    }

    public boolean save(String fileName){
        service.save(fileName);
        return true;
    }

    public boolean printInfo() {
        view.print(service.printInfo());
        return true;
    }

    public boolean printFTrees() {
        view.print(service.printTrees());
        return true;
    }

    public boolean printTree() {
        view.print(service.printTree());
        return true;
    }

    public boolean printMember(String name) {
        view.print(service.printMemberInfo(name));
        return true;
    }
}