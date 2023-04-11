package presenter;

import familyTree.Service;
import member.Gender;
import ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addMember(String name, String surname, Gender gender, String dateBirth) {  // TODO
        service.addHuman(name, surname, gender, dateBirth);
    }

    public boolean getMembers(){ // TODO
        return getMembers();
    }
}
