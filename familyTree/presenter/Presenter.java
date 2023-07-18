package familyTree.presenter;

import familyTree.model.human.Human;
import familyTree.model.service.Service;
import familyTree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String surname, String name, LocalDate dateOfBirthday, LocalDate dateOfDeath, String father, String mother) {
        service.addHuman(surname, name, dateOfBirthday, null, father, mother);
        //какой-то ответ
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}
