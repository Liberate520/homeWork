package Presenter;

import Utils.OperationsWithFile;
import View.View;
import Model.FamilyTree.FamilyTree;

public class Presenter<E extends Comparable<E>> {
    private FamilyTree<E> model;
    private final View view;

    public Presenter(View view) {
        this.model = new FamilyTree<>();
        this.view = view;
    }

    //region ImportExport

    public void saveToFile(String fileName) {
        OperationsWithFile.saveToFile(model, fileName);
        view.print("File exported successfully!");
    }

    public void readFromFile(String fileName) {
        try {
            model = (FamilyTree<E>) OperationsWithFile.readFromFile(fileName);
            view.print("File imported successfully!");
        } catch (Exception e) {
            view.print("An error occurred during importing the file!");
        }
    }

    //endregion
}
