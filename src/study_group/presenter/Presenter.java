package study_group.presenter;

import study_group.model.Service;
import study_group.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
    }

    public void getInfo() {
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByAge();
        getInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfo();
    }
}
