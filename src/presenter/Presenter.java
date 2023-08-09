package presenter;


import java.time.LocalDate;

import model.service.Service;
import view.Console;
import view.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(Console console) {
        this.view = console;
        service = new Service();
    }


    public void addHuman(String name, LocalDate dateOfBirth, String pol){
        service.addHuman(name, dateOfBirth, pol);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }
    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }
    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }
    public void sortById() {
        service.sortById();
        getHumansListInfo();
    }
    public void remove(long id) {
        service.remove(id);
        getHumansListInfo();
    }
    public void setWedding(long id1, long id2) {
        service.setWedding(id1, id2);
        getHumansListInfo();
    }
    public void setDivorce(long id1, long id2) {
        service.setDivorce(id1, id2);
        getHumansListInfo();
    }
    public void load(){
        service.load();
    }
    public void save(){
        service.save();
    }
}
