package presenter;

import model.People.Comparators.PersonComparatorByGender;
import model.People.Comparators.PersonComparatorById;
import model.People.Comparators.PersonComparatorByIdReverse;
import model.People.Comparators.PersonComparatorByName;
import model.People.Person;
import model.Service;
import ui.Console;
import ui.View;
import model.Tree.FamilyTree;


import java.security.Provider;
import java.util.Arrays;
import java.util.List;

public class Presenter {
    public View view;
    public Service service;
    public Console console;
    public Person person;
    public Presenter(View view, Service service) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }
    public void getTreeInfo() {
        String answer = service.getTreeInfo();
        view.print(answer);
    }
    public void searchPersonDescendance(String nameOfAsc){
         view.print(service.searchPersonDescendance(nameOfAsc).toString().replaceAll("[ \\[ \\] ]", ""));
    }
    public void searchPerson(String name){
        view.print(service.searchPerson(name).toString().replaceAll("[ \\[ \\] ]", ""));
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
    public void addTargarien(Person person){
        service.addTargarien(person);
    }
    public void dataOutput(){service.dataOutput();}
    public void deserialization(){service.deserialization();}
    public void getInfo(){service.getInfo();}
}
