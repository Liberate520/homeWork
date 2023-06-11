package presenter;

import model.Gender;
import model.Human;
import model.Service;
import view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showList(){service.showList();}
    public void sortByName(){
        service.sortByName();
    }
    public void sortByBirthDate(){
        service.sortByBirthDate();
    }
    public void addHuman(String name, LocalDate date, Gender gender)
    {
        Human newHuman = new Human();
        newHuman.setName(name);
        newHuman.setDateOfBirth(date);
        newHuman.setGender(gender);
        service.addHuman(newHuman);
    }
    public void findByName(String name){
        System.out.println(service.findByName(name));
    }
    public void findBrothers(String name){
        System.out.println(service.findBrothers(name));
    }
    public void SaveToFile(String filename) throws IOException {
        service.SaveToFile(filename);
    }
    public void LoadFromFile(String filename) throws IOException, ClassNotFoundException {
        service.LoadFromFile(filename);
    }


}
