package presenter;

import model.Service;
import model.human.Human;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void addHuman(String firstName, String lastName, String dob, Human mother, Human father){
        service.addHuman(firstName, lastName, dob, mother, father);
    }
    public void addHuman(String firstName, String lastName, String dob, int motherId, int fatherId){
        service.addHuman(firstName, lastName, dob, motherId, fatherId);
    }

    public void getInfo(){
        view.print(service.getInfo());
    }
}
