package presenter;

import model.Service;
import java.time.LocalDate;
import model.Gender;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    
    public void addHuman(String firstName, String lastName, LocalDate birthDate, Gender gender){
        service.addHuman(firstName, lastName, birthDate, gender);
    }

    public void getInfo(){
        view.print(service.getInfo());
    }
}
