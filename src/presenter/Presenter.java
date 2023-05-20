package presenter;

import model.Elements.TreeElement;
import model.Model;
import model.Tree.GenealogicalTree;
import UI.View;

public class Presenter{
    private Model model;
    private View view;
    public Presenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.setPresenter(this);

    }

    public void addTreeElement(String name, int birthday, int deathDay) {
        view.print(model.addElement(name, birthday, deathDay));
    }

    public void getTreeElementList() {
        for (var element :
                model.getTreeElementList()) {
            view.print(element.toString());
        }

    }

    public void findTreeElement(String name) {
        view.print(model.findTreeElement(name).toString());
    }

    public void sort(){
        model.sort();
        view.print("Отсортировано.");
    }
    public void load(String fileName){
        model.load(fileName);
        view.print("Загружено.");
    }
    public void save(String fileName){
        model.save(fileName);
        view.print("Сохранено.");
    }
    public void addChildren(String parent, String child){
        view.print(model.addChildren(parent, child));
    }
    public void setFather(String child, String father){
        view.print(model.setFather(child, father));
    }
    public void setMother(String child, String mother) {
        view.print(model.setMother(child, mother));
    }
}
