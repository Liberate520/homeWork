package tree.presenter;

import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.service.Service;
import tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    private final String FILEPATH = "saveTree.txt";

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void getInfo() {
        String info = service.getInfo();
        view.print(info);

    }

    public void addFromConsoleHuman(String humanName, LocalDate humanBirthDay, Gender humanGender) {
        System.out.println("Добавление записи");
        service.addHuman(humanName, humanBirthDay, humanGender);
    }

    public void getFromConsoleHuman(String choice) {
        System.out.println("Получение одной записи по имени");
        Human human = service.getByName(choice);
        if (human != null){
            view.print(human.toString());
        } else {
            System.out.println("Такого человека нет");
        }
    }

    public void getFromConsoleAllHuman() {
        System.out.println("Получение всех записей");
        String info = service.getInfo();
        view.print(info);
    }

    public void save() {
        service.save(FILEPATH);
    }
}
