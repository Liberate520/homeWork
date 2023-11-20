package presenter;

import view.View;
import model.service.Service;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman() {
        service.addHuman(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent);
        //какой-то ответ
        getHumanInfo();
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumantInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }
}
