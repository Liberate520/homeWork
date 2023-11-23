package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addElement(String name, LocalDate bd, Gender gender) {
        service.addHuman(name, bd, gender);
    }

    public void getFamilyTree() {
        String answer = service.getFamilyTree();
        view.answer(answer);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }
}
