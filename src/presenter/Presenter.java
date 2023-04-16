package presenter;

import model.Service;
import model.human.Gender;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName, Gender gender) {
        String ans = service.addHuman(firstName, lastName, gender);
        view.print(ans);
    }

    public void getHumanList() {
        String ans = service.getHumanList();
        view.print(ans);
    }
}
