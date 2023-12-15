package presenter;

import model.HumanModel.*;
import model.service.*;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Presenter(View view, String nameFile) {
        this.view = view;
        service = new Service(nameFile);
    }

    public void addEntity(Human entity) {
        service.add(entity);
    }

    public void SaveInFile(String filename) {
        this.service.SaveObject(filename);
    }

    public void LoadFile(String filename) {
        this.service.LoadObject(filename);
    }

    public void PrintAll() {
        this.service.printAll();
    }

    public void setFather(int id1, int id2) {
        this.service.setFather(id1, id2);
    }

    public void setMather(int id1, int id2) {
        this.service.setMother(id1, id2);
    }

    public void GetParrents(int id) {
        this.service.getParents(id);
    }

}
