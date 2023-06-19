package presenter;

import model.Gender;
import model.Service;
import view.View;

import java.io.IOException;
import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public String showList(){
        return service.showList();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByBirthDate(){
        service.sortByBirthDate();
    }
    public void addHuman(String name, LocalDate date, Gender gender, String fathersName, String mothersName)
    {
        service.addHuman(name, date, gender, fathersName, mothersName);
    }
    public String findByName(String name)
    {
        return service.findByName(name);
    }
    public void findBrothers(String name){
        System.out.println(service.findBrothers(name));
    }
    public void saveToFile(String filename) throws IOException {
        service.saveToFile(filename);
    }
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        service.loadFromFile(filename);
    }

}
