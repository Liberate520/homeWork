package presenter;

import model.Core;
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
        view.showResult(core.loadTree(path));
    }

    public void newTree() {
        view.showResult(core.newTree());
    }

    public void saveTree(String path) {
        view.showResult(core.saveTree(path));
    }

    public void getTreeFullInfo() {
        view.showResult(core.getTreeFullInfo());
    }

    public void sortByHierarchyLevel() {
        view.showResult(core.sortByHierarchyLevel());
    }

    public void addNewHumanInTree(String firstName,
                                 String midName,
                                 String lastName,
                                 String gender) {
        String result = core.addNewHumanInTree(firstName, midName, lastName, gender);
        view.showResult(result);
    }

    public void setCurrentHumanById(int id) {
        String result = core.setCurrentHumanById(id);
        view.showResult(result);
        view.showResult(core.getCurrentHumanFullInfo());
    }

    public void getCurrentHumanFullInfo() {
        view.showResult(core.getCurrentHumanFullInfo());
    }

    public void setBirthDateToCurrHuman(int day, int month, int year) {
        String result = core.setBirthDateToCurrHuman(day, month, year);
        view.showResult(result);
    }

    public void setDeathDateToCurrHuman(int day, int month, int year) {
        String result = core.setDeathDateToCurrHuman(day, month, year);
        view.showResult(result);
    }

    public void setParentToCurrHumanById(int id) {
        String result = core.setParentToCurrHumanById(id);
        view.showResult(result);
    }

    public void addChildToCurrHumanById(int id) {
        String result = core.addChildToCurrHumanById(id);
        view.showResult(result);
    }
}