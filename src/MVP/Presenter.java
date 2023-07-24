package MVP;

import Models.FamilyTree.FamilyTree;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Presenter<E extends Comparable<E>> {
    private final Model<E> model;
    private final View view;

    public Presenter(Model<E> model, View view) {
        this.model = model;
        this.view = view;
    }


    private FamilyTree<E> selectedTree;


    public void start() {
        while (true) {
            if (selectedTree == null) {
                mainMenu();
            }
            else {
                treeMenu();
            }
        }
    }

    private int showMenu(String menu, int min, int max) {
        int res = 0;
        do {
            view.showMenu(menu);
            try {
                res = Integer.parseInt(view.getInput("Select: "));
            } catch (Exception e) {}
        } while (!(res >= min && res <= max));
        return res;
    }

    //region Menus

    private void mainMenu() {
        switch (showMenu("1 - Create tree\n" +
                "2 - Select tree\n", 1, 2)) {
            case 1:
                String name = view.getInput("Enter name: ");
                model.addFamilyTree(name);
                break;
            case 2:
                var list = model.getTrees().stream().map(FamilyTree::getTreeName).collect(Collectors.toList());
                view.printObjects(list);
                String selection = view.getInput("Enter name: ");
                if (model.getFamilyTree(selection) != null) {
                    selectedTree = model.getFamilyTree(selection);
                }
                break;
        }
    }

    private void treeMenu() {
        switch (showMenu("1 - Print tree\n" +
                "2 - Rename tree\n" +
                "3 - Delete tree\n", 1, 3)) {
            case 1:
                view.print(selectedTree.toString());
                break;
            case 2:
                break;
            case 3:
                model.removeFamilyTree(selectedTree);
                selectedTree = null;
                break;
        }
    }

    //endregion
}
