package homeWork.family_tree.presenter;


import homeWork.family_tree.model.service.Service;
import homeWork.family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String birthDate) {
        service.addHuman(name, birthDate);
        getHumanInfo();
    }

    public void getHumanInfo() {
        view.printAnswer(service.getHumanInfo());
    }

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanInfo();
    }
}
