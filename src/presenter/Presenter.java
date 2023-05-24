package presenter;

import model.Service;
import model.human.Human;
import ui.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName, String dob, int motherId, int fatherId){
        service.addHuman(firstName, lastName, dob, motherId, fatherId);
    }

    public void getInfo(){
        view.print(service.getInfo());
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }
}
