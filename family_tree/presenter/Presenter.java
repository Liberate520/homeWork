package family_tree.presenter;

import java.time.LocalDate;
import java.util.List;

import family_tree.model.humans.Gender;
import family_tree.model.humans.Human;
import family_tree.service.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Presenter(ConsoleUI consoleUI){

    }

    public void addHuman(String name,LocalDate birthDate, Gender gender) {
        service.addHuman(name,birthDate,gender);
        
    }
    public void getHumansInfo(){
        String info = service.getHumansInfo();
        view.print(info);
    }

    public void sortByYear() {
        service.sortByYear();
    }

    public List<Human> getWomenInfo(){
        return service.getPeopleByGender(Gender.FEMALE);
}

    public List<Human> getMenInfo() {
        return service.getPeopleByGender(Gender.MALE);
    }
    


    }

    

    

