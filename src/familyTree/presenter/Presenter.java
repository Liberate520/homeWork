package familyTree.presenter;

import familyTree.model.ServiceHuman;
import familyTree.ui.View;

public class Presenter {
    private View view;
    private ServiceHuman service;

    public Presenter(View view, ServiceHuman service) {
        this.view = view;
        this.service = service;

        view.setPresenter(this);
    }

    public void addToTree(String treeName,
                          String fullName, String gender,
                          String dateOfBirth, String dateOfDeath,
                          String mother, String father,
                          String spouse, String children){
        service.addToTree(treeName, fullName, gender,
                dateOfBirth, dateOfDeath,
                mother, father, spouse, children);
    }

    public void getAllInfo(){
        view.show(service.getAllInfo());
    }

    public void getInfoConcreteTree(String treeName){
        view.show(service.getInfoConcreteTree(treeName));
    }

    public void getInfoHumanFromTree(String treeName, String fullName) {
        view.show(service.getInfoHumanFromTree(treeName, fullName));
    }

    public void getInfoGender(String treeName, String fullName){
        view.show(service.getInfoGender(treeName, fullName));
    }

    public void getInfoParents(String treeName, String fullName){
        view.show(service.getInfoParents(treeName, fullName));
    }

    public void getInfoDateOfBirth(String treeName, String fullName){
        view.show(service.getInfoDateOfBirth(treeName, fullName));
    }

    public void getInfoDateOfDeath(String treeName, String fullName){
        view.show(service.getInfoDateOfDeath(treeName, fullName));
    }

    public void getInfoAge(String treeName, String fullName){
        view.show(service.getInfoAge(treeName, fullName));
    }

    public void getInfoSpouse(String treeName, String fullName){
        view.show(service.getInfoSpouse(treeName, fullName));
    }

    public void getInfoChildren(String treeName, String fullName){
        view.show(service.getInfoChildren(treeName, fullName));
    }
}