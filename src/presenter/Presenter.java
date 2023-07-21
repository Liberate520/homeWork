package presenter;

import model.Core;
import model.io.Loader;
import model.io.Saver;
import view.View;

public class Presenter {
    private View view;
    private Core core = new Core();

    public Presenter(View view) {
        this.view = view;
    }

    public boolean isSaved() {
        return core.isSaved();
    }

    public void loadTree(String path) {
        view.showResult(core.loadTree(new Loader(path)));
    }

    public void newTree() {
        view.showResult(core.newTree());
    }

    public void saveTree(String pathName) {
        view.showResult(core.saveTree(new Saver(pathName)));
    }

    public void getTreeFullInfo() {
        view.showResult(core.getTreeFullInfo());
    }

    public void sortByHierarchyLevel() {
        view.showResult(core.sortByHierarchyLevel());
    }

    public void addNewItemInTree(String firstName,
                                  String midName,
                                  String lastName,
                                  String gender) {
        String result = core.addNewItemInTree(firstName, midName, lastName, gender);
        view.showResult(result);
    }

    public void setCurrentItemById(int id) {
        String result = core.setCurrentItemById(id);
        view.showResult(result);
        view.showResult(core.getCurrentItemFullInfo());
    }

    public void getCurrentItemFullInfo() {
        view.showResult(core.getCurrentItemFullInfo());
    }

    public void setBirthDateToCurrItem(int day, int month, int year) {
        String result = core.setBirthDateToCurrItem(day, month, year);
        view.showResult(result);
    }

    public void setDeathDateToCurrItem(int day, int month, int year) {
        String result = core.setDeathDateToCurrItem(day, month, year);
        view.showResult(result);
    }

    public void setParentToCurrItemById(int id) {
        String result = core.setParentToCurrItemById(id);
        view.showResult(result);
    }

    public void addChildToCurrItemById(int id) {
        String result = core.addChildToCurrItemById(id);
        view.showResult(result);
    }
}