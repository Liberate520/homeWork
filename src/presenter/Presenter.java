package presenter;

import model.People.Comparators.PersonComparatorByGender;
import model.People.Comparators.PersonComparatorById;
import model.People.Comparators.PersonComparatorByIdReverse;
import model.People.Comparators.PersonComparatorByName;
import model.People.Person;
import model.Service;
import ui.View;
import model.Tree.FamilyTree;


import java.security.Provider;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void getTreeInfo() {
        service.getTreeInfo();
    }
    public void searchPersonDescendance(){
        service.searchPersonDescendance();
    }
    public void searchPerson(){
        service.searchPerson();
    }
    public void sortByName() {
        service.sortByName();
    }
    public void sortById(){
        service.sortById();
    }
    public void sortByIdReverse(){
        service.sortByIdReverse();
    }
    public void sortByGender(){
        service.sortByGender();
    }
//    КАК ИХ СЮДА ЗАХУЯРИТЬ???!!!
    public void addTargarien(Person person){
        service.addTargarien(person);
    }
}
