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

}
