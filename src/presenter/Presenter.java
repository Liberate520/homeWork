package presenter;

import service.Service;
import ui.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(List<String> human) {
        service.addHuman(human.get(0), human.get(1), LocalDate.parse(human.get(2)));
        System.out.println("человек добавлен");
    }

    public void delHuman(int id) {
        if (service.delHuman(id)) {
            view.print("Данные удалены");
        }
        else {
            view.print("Удаление по этому ID невозможно");
        }
    }
    public void searchHuman(String lastName) {
        view.print(service.searchHuman(lastName).toString());
    }

    public void loadList(String nameFile) {
        service.loadFamilyGroup(nameFile);
        view.print("Загружено");
    }

    public void showList() {
        view.print(service.getFamilyGroup().toString());
    }
}