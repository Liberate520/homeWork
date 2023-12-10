package presenter;

import model.creatures.Gender;
import service.Service;
import view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }

    public String showTree(){
        return service.showTree();
    }

    public void addCreature(String firstName, String lastName, Gender gender,
                            LocalDate birthDate){
        service.addHuman(firstName, lastName, gender, birthDate);
    }

}
