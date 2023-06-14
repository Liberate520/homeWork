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
    public void addHuman(String name, LocalDate date, Gender gender)
    {
        service.addHuman(name, date, gender);
    }
    public String findByName(String name)
    {
        return service.findByName(name);
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
