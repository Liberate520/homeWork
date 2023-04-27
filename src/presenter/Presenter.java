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

    public void onClick1() {
        String answer = service.get();
        view.print(answer);
    }

    public void onClick2(String name) {
        service.add(name);
    }

    public void onClick3(String name) {
        if (service.find(name) == null)
            view.print("Человек не найден в древе.");
        else
            view.print(service.find(name).getInfo());
    }

    public void onClick4() {
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
            service.add(father);
        }
        service.find(name).setFather(service.find(father));
        service.find(father).addChildren(service.find(name));
    }

    public void findMother(String mother, String name) {
        if (service.find(mother) == null) {
            service.add(mother);
        }
        service.find(name).setMother(service.find(mother));
        service.find(mother).addChildren(service.find(name));
    }

    public void removeHuman(String name) {
        service.remove(name);
    }

}
