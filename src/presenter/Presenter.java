package presenter;

import java.io.IOException;

import model.project.FamilyTree;
import model.project.Human;
import ui.View;

public class Presenter {
    private View view;
    private FamilyTree<Human> familyTree;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
        familyTree = new FamilyTree<>();
    }

    public String createNewTree() { return "Дерево создано."; }

    public String loadTree() throws ClassNotFoundException, IOException {
        familyTree = familyTree.open();
        if (familyTree == null) return "Ошибка";
        else return "Дерево загружено.";
    }

    public String addTreeElement(StringBuilder next) {

        return "Успешно добавлен в древо.";
    }

    public String showTree() { return familyTree.getTree(); }

    public String findTreeElement(String nextLine) { return familyTree.getInfoHuman(nextLine); }

    public String saveTree() {
        familyTree.save(familyTree);
        return "Дерево успешно сохранено.";
    }

    public String showMother() {
        return familyTree.getInfoMother(null);
    }

    public String showChildrens() {
        return familyTree.getInfoChildren(null);
    }

    public String showFather() {
        return familyTree.getInfoFather(null);
    }

    public String sortByName() {
        familyTree.sortByName();
        return "Отсортированно по имени.";
    }

    public String sortByYearOfBirth() {
        familyTree.sortByYear();
        return "Отсортированно по году рождения.";
    }

    public String formatToTxt(String file_name) {
        familyTree.save(file_name);
        return "Сохранено.";
    }

    
}
