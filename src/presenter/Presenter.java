package presenter;

import java.time.LocalDate;
import java.util.List;

import service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addPerson(List<String> person) {
        service.addPerson(person.get(0), person.get(1), LocalDate.parse(person.get(2)));
    }

    public void delPerson(int id) {
        if (service.delPerson(id)) {
            view.print("Данные удалены");
        }
        else {
            view.print("Удаление по этому ID невозможно");
        }
    }
    public void searchPerson(String lastName) {
        view.print(service.searchPerson(lastName).toString());
    }

    public void saveList(String nameToFile) {
        service.saveFamilyGroup(nameToFile);
        view.print("Сохранено");
    }

    public void loadList(String nameFile) {
        service.loadFamilyGroup(nameFile);
        view.print("Загружено");
    }

    public void showList() {
        view.print(service.getFamilyGroup().toString());
    }
}