package tree.presenter;

import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.service.Service;
import tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addFromConsoleHuman(String humanName, LocalDate humanBirthDay, Gender humanGender) {
        service.addHuman(humanName, humanBirthDay, humanGender);
    }

    public void getFromConsoleHuman(String choice) {
        Human human = service.getByName(choice);
        if (human != null){
            view.print(human.toString());
        } else {
            System.out.println("Такого человека нет");
        }
    }

    public void getFromConsoleAllHuman() {
        String info = service.getInfo();
        view.print(info);
    }

    public void save() {
        service.save();
    }
}
