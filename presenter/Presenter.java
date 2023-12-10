package presenter;

import java.time.LocalDate;

import model.FamilyModel.*;
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
        this.service.SaveInFile(filename);
    }

    public void LoadFile(String filename) {
        this.service.LoadFile(filename);
    }

    public void PrintAll() {
        this.service.PrintAll();
    }

    public void setFather(int id1, int id2) {
        this.service.getID(id1).setFather(this.service.getID(id2));
    }

    public void setMather(int id1, int id2) {
        this.service.getID(id1).setMather(this.service.getID(id2));
    }

    public void GetParrents(int id) {
        this.service.GetParrents(id);
    }

}
