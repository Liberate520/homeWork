package presenter;

import human.Gender;
import model.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.SetPresenter(this);
    }
    public void addHuman(String name, Integer yearOfBirth, Gender gender){
        service.addHuman(name, yearOfBirth, gender);
    }
    public void getHuman(){
        view.print(service.getInfo());
    }
    public void addChild(String name, int yearOfBirth, Gender gender, String nameOfFather, String nameOfMother){
        service.addChild(name, yearOfBirth, gender, nameOfFather, nameOfMother);
    }
    public void saveFile(){
        service.saveFile();
    }
    public void readFile(){
        service.readFile();
    }

}
