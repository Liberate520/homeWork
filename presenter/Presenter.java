package presenter;

import model.service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;

        view.serPresenter(this);
    }

    public void getRecords(String all) {
        service.read();
        String answer = service.get(all);
        view.print(answer);
    }

    public void addRecord(String name, String father, String mother, String year) {

        String answer = service.getNote(name, father, mother, year);
        view.print("Человек добавлен: ");

    }

    public void getSaveTree() {
        service.save();
        view.print("Файл сохранен");

    }

    public void getReadTree() {
        service.read();
        view.print("Чтение файла");
    }

    public void getSorterByName() {
        service.read();
        service.sortByName();
    }

    public void getSortBirthDate() {
        service.read();
        service.sortBirthDate();
    }

    public void getPrint() {
        service.read();
        service.print();
    }
}
