package src.presenter;

import src.ui.View;
import src.treeApi.*;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showNames() {
        String answer = service.get();
        view.print(answer);
    }

    public void add(String name) {
        service.add(name);
    }

    public void find(String name) {
        if (service.find(name) == null)
            view.print("Человек не найден в древе.");
        else
            view.print(service.find(name).getInfo());
    }

    public void getAllInfo() {
        view.print(service.getInfo());
    }

    public void loadFile() {
        service.load();
    }

    public void saveFile() {
        service.save();
    }

    public void findFather(String father, String name) {
        if (service.find(father) == null) {
            view.print("Такого человека нет в древе.");
        } else {
            service.find(name).setFather(service.find(father));
            service.find(father).addChildren(service.find(name));
        }
    }

    public void findMother(String mother, String name) {
        if (service.find(mother) == null) {
            view.print("Такого человека нет в древе.");
        } else {
            service.find(name).setMother(service.find(mother));
            service.find(mother).addChildren(service.find(name));
        }
    }

    public void removeHuman(String name) {
        service.remove(name);
    }

}
