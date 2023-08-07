package Presenter;

import Model.Family;
import Model.FamilyMember;
import Model.Gender;
import View.View;
import Model.Service.*;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String familyStatus) {
        service.addHuman(name, gender, dateOfBirth, dateOfDeath, familyStatus);
        //TODO какой-то ответ
    }

    public FamilyMember findHuman(String name) {
        return service.findHuman(name);
    }
    public void removeFamilyMember(FamilyMember human) {
        service.removeFamilyMember(human);
    }

    public void getFamilyInfo() {
        String info = service.getFamilyInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void saveFile() {
        service.saveFile();
    }

    public void load() {
        Family info = service.loadFile();
        if (info == null) {
            System.out.println("File not found");
        } else {
            view.printAnswer(info.getFamilyInfo());
        }
    }
}