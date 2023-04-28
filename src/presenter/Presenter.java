package presenter;

import essence.Human;
import service.Service;
import ui.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Presenter {
    private final View view;
    private final Service<Human> service;

    public Presenter(View view, Service<Human> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onClick(String text) {
        List<String> answer = service.getFamily();
        StringBuilder sb = new StringBuilder();
        for (String s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public List<String> getMembers(){
        return service.getFamily();
    }
    public void onRoll(String human){
        List<Human> answer = new ArrayList<>(service.getRelatives(service.findByName(human)));
        StringBuilder sb = new StringBuilder();
        for (Human s:answer) {
            sb.append(s);
            sb.append("\n");
        }
        view.print(String.valueOf(sb));
    }
    public void save() throws IOException {
        service.save();
    }
    public void load() throws IOException, ClassNotFoundException {
        service.loadFamily();
    }
//    public void addNewPerson(String s){
//        s.split(",");
//        service.addMember();
//    }
}

