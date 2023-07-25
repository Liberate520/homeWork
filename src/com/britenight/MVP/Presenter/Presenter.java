package com.britenight.MVP.Presenter;

import com.britenight.Utils.OperationsWithFile;
import com.britenight.MVP.View.View;
import com.britenight.MVP.Model.FamilyTree.FamilyTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

public class Presenter<E extends Comparable<E>> {
    private FamilyTree<E> model;
    private final View view;
    private final Fabric<E> fabric;

    public Presenter(View view, Fabric<E> fabric) {
        this.model = new FamilyTree<>();
        this.view = view;
        this.fabric = fabric;
    }

    //region ModelManagement

    public void printModel() {
        view.print(model.toString());
    }

    public void saveToFile(String fileName) {
        try {
            assert model != null;
            OperationsWithFile.saveToFile(model, fileName);
            view.print("File exported successfully!");
        } catch (Exception e) {
            view.print("An error occurred during saving the file!");
        }
    }

    public void readFromFile(String fileName) {
        try {
            model = (FamilyTree<E>) OperationsWithFile.readFromFile(fileName);
            assert model != null;
            view.print("File imported successfully!");
        } catch (Exception e) {
            view.print("An error occurred during importing the file!");
        }
    }

    //endregion

    //region ObjectsManagement

    public void getObjects() {
        ArrayList<E> objects = model.getObjects();
        for (E object : objects) {
            view.print(object.toString());
        }
    }

    public void addObject(Function<Map<String, String>, Map<String, String>> prompt) {
        boolean result = model.addObject(fabric.create(prompt));
        if (result) {
            view.print("The object successfully added!");
        } else {
            view.print("An error occurred during adding the object!");
            view.print("Probably the object already exists.");
        }
    }

    public void removeObject(E object) {
        boolean result = model.removeObject(object);
        if (result) {
            view.print("The object successfully removed!");
        } else {
            view.print("An error occurred during removing the object!");
            view.print("Probably the object does not exist.");
        }
    }

    public void sortAscending() {
        model.sort(Comparator.naturalOrder());
        view.print("The model has been sorted by ascending!");
    }

    public void sortDescending() {
        model.sort(Comparator.reverseOrder());
        view.print("The model has been sorted by descending!");
    }

    //endregion

    //region RelationManagement

    public void getParents(E object) {
        view.print(object.toString() + " has:");
        for (String relation : model.getParents(object)) {
            view.print(relation);
        }
    }

    public void getChildren(E object) {
        view.print(object.toString() + " has:");
        for (String relation : model.getChildren(object)) {
            view.print(relation);
        }
    }

    public void addParent(E object, E parent) {
        model.addParent(object, parent);
    }

    public void removeParent(E object, E parent) {
        model.removeParent(object, parent);
    }

    public void addChild(E object, E child) {
        model.addChild(object, child);
    }

    public void removeChild(E object, E child) {
        model.removeChild(object, child);
    }

    //endregion
}
