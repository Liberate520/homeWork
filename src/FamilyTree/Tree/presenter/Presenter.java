package FamilyTree.Tree.presenter;

import FamilyTree.Tree.model.FileHander.readSave;
import FamilyTree.Tree.model.HumanGroup.Human.Human;
import FamilyTree.Tree.model.HumanGroup.HumanGroup;
import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.view.View;



public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public Presenter(View view, Service service) {
    }


    public void getHumansInfo() {
        String answer = service.getHumansInfo();
        view.printAnswer(answer);
    }

    public void sortName() {
        service.sortByName();
        getHumansInfo();
    }

    public void sortDateOfBirth() {
        service.sortDateOfBirth();
        getHumansInfo();
    }

    public void sortPatronymic() {
        service.sortPatronymic();
        getHumansInfo();
    }
    public void saveFam(String path) {
        service.saveFam(path);
       getHumansInfo();
    }
    public void readFam(Object path) {
        service.readFam(path);
        getHumansInfo();
    }


    public String addParent(HumanGroup humanGroup, String name, String surname, String gender, String dateOfBirth){
        return service.addParent(humanGroup,name, surname, gender, dateOfBirth);
    }

    public void addHumans(String name, String patronymic, String dateOfBirthString) {
    }
    public String addChildren(HumanGroup humanGroup, String name, String surname, String gender) {
        return service.addChildren(humanGroup, name, surname, gender);
    }
}
