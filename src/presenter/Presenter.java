package presenter;

import model.Service;
import model.human.Gender;
import ui.View;

public class Presenter {
    private View view;
    private Service servise;
    

    public Presenter(View view, Service service) {
        this.view = view;
        this.servise = service;
        view.setPresenter(this);
    }

    public void addHuman(int id, String name, String surname, String dateOfBirth, Gender gender) {
        servise.addHuman(id++, name, surname, dateOfBirth, null);
    }
    
    public void getInfo(){
        view.print(servise.getInfo());
    }
}
