package presenter;

import model.project.FamilyTree;
import model.project.Human;
import ui.View;

public class Presenter {
    private View view;
    private FamilyTree<Human> familyTree;
    private String nameToSearch;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
        this.familyTree = new FamilyTree<>();
    }

    public String createNewTree() {
        familyTree = new FamilyTree<>();
        return "Дерево создано."; 
    }

    public String loadTree() {
        this.familyTree = (FamilyTree<Human>) familyTree.loadTree();
        if (familyTree == null) return "Ошибка загрузки.";
        else return "Дерево загружено.";
    }

    public String addTreeElement(String name, String sex, Integer yearOfbihtd, String father, String mother) {    
        familyTree.add(new Human(name, sex, yearOfbihtd, familyTree.getHuman(father), familyTree.getHuman(mother)));
        return "Успешно добавлен в древо.";
    }

    public String showTree() { return familyTree.getTree(); }

    public String findTreeElement(String nextLine) { 
        this.nameToSearch = nextLine;
        return familyTree.getInfoHuman(nameToSearch); 
    }

    public String saveTree() {
        familyTree.saveTree(familyTree);
        return "Дерево успешно сохранено.";
    }

    public String showMother() {
        return familyTree.getInfoMother(nameToSearch);
    }

    public String showChildrens() {
        return familyTree.getInfoChildren(nameToSearch);
    }

    public String showFather() {
        return familyTree.getInfoFather(nameToSearch);
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
        familyTree.saveTo(familyTree, file_name);
        return "Сохранено.";
    }
}
