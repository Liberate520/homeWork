package presenter;

import model.FamilyTreeService;
import view.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
}
