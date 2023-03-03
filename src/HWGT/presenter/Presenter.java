package HWGT.presenter;

import HWGT.model.Service;
import HWGT.ui.View;

import java.io.IOException;

public class Presenter {
    private View view;

    private Service service = new Service();
    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void testTree() {
        service.fillTestTree();
//        System.out.println("тестовое дерево создано");
    }

    public String loadData() throws IOException, ClassNotFoundException {return service.loadData();}

    public String saveData() throws IOException {return service.saveData();}

    public String addPerson(String personName, String personSex, Integer birthData, Integer deathData) {
        return service.addPerson(personName, personSex, birthData, deathData);

//        System.out.println("добавление человека работает");
    }

    public String updatePerson(String personName, Integer birthDate, Integer deathDate) {
        return service.updatePerson(personName, birthDate, deathDate);
//        System.out.println("изменение данных работает");
    }

    public String personEnvironment(String personName, String fatherName, String motherName, String childName, String childSex) {
        return service.personEnvironment(personName, fatherName, motherName, childName, childSex);
    }

    public String searchPerson(String nextLine) {return service.searchPerson(nextLine);}


    public void sortByName() {
        service.sortByName();

    }

    public void sortByBirthDate() {
        service.sortByBirthDate();

    }

    public String printTree(){
        return service.printTree();
    }

    public boolean checkName(String personName){
        return service.checkName(personName);
    }
}