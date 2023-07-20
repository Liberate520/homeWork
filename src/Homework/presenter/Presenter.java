package Homework.presenter;

import Homework.model.Human.Gender;
import Homework.model.Human.Human;
import Homework.model.service.Service;
import Homework.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birth, LocalDate death, Human father, Human mother){
        service.addHuman(name, gender, birth, death, father, mother);
        getHumanInfo();
    }

    public void getHumanInfo() { view.printAnswer(service.getHumanInfo());}

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getHumanInfo();
    }

    public void saveInFile(){
        service.saveINFile();
    }

    public void readFile(){
        service.readFile();
    }

    public Human addParents(String human){
        Human Human = service.addParents(human);
        return Human;
    }

    public void addChildren(Human human, Human child){
        service.addChildren(human, child);
    }

}
