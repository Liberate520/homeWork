package presenter;

import model.human.Gender;
import model.human.Human;
import model.service.ServiceHuman;
import view.ConsoleUI;

public class Presenter {
    private ServiceHuman service;

    public Presenter() {
        this.service = new ServiceHuman();
    }

    public void addTreeItem(String name, Gender gender, String birthDate,
                            Human father, Human mother){
        service.addTreeItem(name, gender,birthDate,father,mother);
    }

    public void addTreeItem(String name, Gender gender, String birthDate){
        service.addTreeItem(name, gender,birthDate);
    }
    public Human getById(long id){
        return service.getById(id);
    }
    public void remove(long id){
        service.remove(id);
    }

    public String getHumanListInfo(){
        return service.getHumanListInfo();
    }

    public void saveAsFile(String path) {
        service.saveAsFile(path);
    }

    public void readFromFile(String path) {
        service.readFromFile(path);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByGender() {
        service.sortByGender();
    }
}
