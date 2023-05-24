package Presenter;

import model.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    // public void addMember(FamilyTreeObject human){
    //     service.addMember(human);
    // }

    public void addMember(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        service.addMember(firstName, lastName, dayOfBirth,
        monthOfBirth, yearOfBirth);
    }
    public void getAllMembers(){
        view.print(service.getAllMembersAsString());
    }

    public void getMembersByName(String name){
        view.print(service.getMembersByNameAsString(name));
    }
}
