package home_work.presenter;

import java.util.List;

import home_work.model.Gender;
import home_work.model.Human;
import home_work.model.service.Service;
import home_work.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void createLink(Human parent, Human child) {
        service.createLink(parent, child);
    }

    public void getTree(String name) {
        service.createTree(name);
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void addHuman(Human human) {
        service.addHuman(human);
    }

    public List<Human> getHumanList() {
        return service.getHumanList();
    } 
}
