package presenter;

import model.ModelService;
import ui.View;

public class Presenter {
    private View view;
    private ModelService<?> model;
    private String nameToSearch;

    public Presenter(View view, ModelService<?> model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public String createNewTree() {
        model.createNewTree();
        return "Дерево создано."; 
    }

    public String loadTree() {
        model.loadTree();
        return "Дерево загружено.";
    }

    public String addTreeElement(String name, String sex, String yearOfbirth, String father, String mother) { 
        Integer yearOfbirthday = Integer.parseInt(yearOfbirth);
        model.addTreeElement(name, sex, yearOfbirthday, father, mother);
        return "Успешно добавлен в древо.";
    }

    public String showTree() { return model.showTree(); }

    public String findTreeElement(String nextLine) { 
        this.nameToSearch = nextLine;
        return model.findTreeElement(nameToSearch); 
    }

    public String saveTree() {
        model.saveTree();
        return "Дерево успешно сохранено.";
    }

    public String showMother() {
        return model.showMother(nameToSearch);
    }

    public String showChildrens() {
        return model.showChildrens(nameToSearch);
    }

    public String showFather() {
        return model.showFather(nameToSearch);
    }

    public String sortByName() {
        model.sortByName();
        return "Отсортированно по имени.";
    }

    public String sortByYearOfBirth() {
        model.sortByYearOfBirth();
        return "Отсортированно по году рождения.";
    }

    public String formatToTxt(String file_name) {
        model.saveTo(file_name);
        return "Сохранено.";
    }
}
