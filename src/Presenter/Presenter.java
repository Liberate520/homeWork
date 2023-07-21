package Presenter;

import Model.fileHandlers.FileHandler;
import Model.service.Service;
import View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());
    }

    public boolean addItem(String name, String[] birthDateArray, String genderString) {
        if (service.addItem(name, birthDateArray, genderString)) {
            return true;
        }
        return false;
    }

    public String getFamilyTreeInfo(String sortBy) {
        switch (sortBy) {
            case "1":
                return service.sortByName();
            case "2":
                return service.sortByBirthDate();
            case "3":
                return service.sortByAge();
            default:
                return service.getFamilyTree();
        }
    }

    public String findItem(String name) {
        return service.findItem(name).toString();
    }

    public boolean checkItem(String name) {
        if (service.checkItem(name)) {
            return true;
        } else {
            view.inputError();
            return false;
        }
    }

    public boolean setDeathDate(String nameHuman, String[] deathDateArray) {
        if (service.setDeathDate(nameHuman, deathDateArray)) {
            return true;
        } else {
            view.inputError();
            return false;
        }
    }

    public boolean createFamily(String nameParent1, String nameParent2, String nameChild) {
        if (service.createRelatings(nameParent1, nameParent2, nameChild)) {
            return true;
        }
        return false;
    }

    public boolean addChild(String nameParent, String nameChild) {
        if (service.addChildren(nameParent, nameChild)) {
            return true;
        }
        return false;
    }

    public boolean addParents(String nameChild, String nameParent1, String nameParent2) {
        if (service.addParents(nameChild, nameParent1, nameParent2)) {
            return true;
        }
        return false;
    }

    public boolean saveTree(String filePath) {
        if (service.saveTree(filePath)) {
            return true;
        }
        return false;
    }

    public boolean loadTree(String filePath) {
        if (service.loadTree(filePath)) {
            return true;
        }
        return false;
    }

    public boolean deleteItem(String nameHuman) {
        if (service.deleteItem(nameHuman)) {
            return true;
        }
        return false;
    }
}
