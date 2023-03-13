package presenter;

import model.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void searchByName(String nextLine) {
        view.print(service.searchByName(nextLine));
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

    public void load() {
        service.load();
    }

    public void sortAlfab() {
        service.sortAlfab();
    }

    public void sortByAge() {
        service.outputAList();
    }

    public boolean addHuman(String fullName, String birth, String mom, String papa) {
        return service.addHuman(fullName, birth, mom, papa);
    }

}

