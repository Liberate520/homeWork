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

    public void addHuman(String firstName, String lastName, Gender gender, LocalDate born) {
        service.addHuman(firstName, lastName, gender, born);
        view.printAnswer("Person added into the family tree.");
    }

    public void getHumanByFullName(String firstName, String lastName){
        view.printAnswer(service.getHumanByFullName(firstName, lastName).toString());
    }

    public void getFamilyTreeInfo() {
        String familyTreeInfo = service.getFamilyTreeInfo();
        view.printAnswer(familyTreeInfo);
    }


    public void sortByFullName() {
        service.sortByFullName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void saveFamilyTree(String fileName){
        service.saveFamilyTree(fileName);
        view.printAnswer("The family tree is saved.");
    }
    public void loadFamilyTree(String fileName){
        service.loadFamilyTree(fileName);
        view.printAnswer("The family tree is loaded.");
    }

    public void addChild(String parentFirstName, String parentSecondName,  String childFirstName, String childSecondName){
        service.addChild(parentFirstName, parentSecondName,  childFirstName, childSecondName);
        view.printAnswer("The child is added.");
    }

}
