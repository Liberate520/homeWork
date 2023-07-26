package com.britenight.MVP.Presenter;

import com.britenight.MVP.Model.FamilyTree.FamilyTree;
import com.britenight.MVP.View.View;
import com.britenight.Utils.OperationsWithFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        try {
            boolean result = model.addObject(fabric.create(prompt));
            if (result) {
                view.print("The object successfully added!");
            } else {
                view.print("An error occurred during adding the object!");
                view.print("Probably the object already exists.");
            }
        } catch (Exception e) {
            view.print("An error occurred during adding the object!");
            view.print("You entered wrong data!");
        }
    }

    public E selectObject(Function<String, String> prompt) {
        ArrayList<E> objects = model.getObjects();
        return select(prompt, objects);
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

    public E selectParent(Function<String, String> prompt, E object) {
        List<E> objects = model.getParents(object);
        return select(prompt, objects);
    }

    public E selectChild(Function<String, String> prompt, E object) {
        List<E> objects = model.getChildren(object);
        return select(prompt, objects);
    }

    public void printRelations(E object) {
        view.print(object.toString() + " has:");
        List<String> relations = model.printRelations(object);
        for (String relation : relations) {
            view.print(relation);
        }
        if (relations.size() == 0) {
            view.print("None");
        }
    }

    public void addParent(E object, E parent) {
        if (object == null || parent == null) return;
        model.addParent(object, parent);
    }

    public void removeParent(E object, E parent) {
        if (object == null || parent == null) return;
        model.removeParent(object, parent);
    }

    public void addChild(E object, E child) {
        if (object == null || child == null) return;
        model.addChild(object, child);
    }

    public void removeChild(E object, E child) {
        if (object == null || child == null) return;
        model.removeChild(object, child);
    }

    //endregion

    private E select(Function<String, String> prompt, List<E> objects) {
        if (objects.size() == 0) return null;

        for (int i = 0; i < objects.size(); i++) {
            view.print(String.format("[%d] - %s", i + 1, objects.get(i).toString()));
        }
        try {
            int res = Integer.parseInt(prompt.apply("\nSelect: "));
            return objects.get(res - 1);
        } catch (Exception e) {
            view.print("Wrong index selected!");
        }
        return null;
    }
}
