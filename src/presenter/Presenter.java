package presenter;

import service.Service;
import ui.View;

import java.util.Date;

public class Presenter {
    private Service service;
    private View view;
    public Presenter(Service service, View view) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void addHuman(String name, String surname, String bdate,String fatherName, String fatherSurname, String motherName, String motherSurname) {
         String answer =   service.addHuman(name,surname,bdate,fatherName,fatherSurname,motherName,motherSurname);
         view.print(answer);
    }

    public void getFamilyTree(){
        view.print(service.getFamilyTree());
    }

}