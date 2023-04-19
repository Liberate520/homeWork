package Tree.presenter;


import Tree.model.Service;
import Tree.model.components.Gender;
import Tree.ui.View;

// класс - связующее звено между view(FamilyTreeService) и service(Console)
public class Presenter {
    private View view;
    private Service service;

    // конструктор
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    // методы передаются на реализацию в сервис
    public void searchByName(String someLine) {
        view.print(service.searchByName(someLine));
    }

    public void outputAList() {
        view.print(service.outputAList());
    }

    public boolean deletePerson(String nextLine) {
        return service.deletePerson(nextLine);
    }

    public void save() {
        service.save();
    }

    public void load() {service.load();}

    public void clearTree(){service.clearTree();}

    public void sortAlfab() {service.sortAlfab();}

    public void sortByAge() {
        service.sortByAge();
    }

    public void addHuman(String fullName, int birth, Gender sex, String mother, String father) {
        service.addHuman(fullName, birth, sex, mother, father);
    }
}

