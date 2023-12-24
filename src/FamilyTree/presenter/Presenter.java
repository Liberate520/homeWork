package FamilyTree.presenter;

import FamilyTree.model.ServiceModPres;
import FamilyTree.view.View;

public class Presenter {
    private View view;
    private ServiceModPres service;

    public Presenter(View view) {
        service = new ServiceModPres();
        this.view = view;
    }

    public void addHuman(String name, String gender, String birthDate, long fatherId, long motherId) {
        String answer = service.addHuman(name, gender, birthDate, fatherId, motherId);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void getHumanListInfo() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void sortByName() {

    }

    public void sortByBirthDate() {

    }
}
