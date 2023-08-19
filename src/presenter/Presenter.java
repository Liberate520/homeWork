package presenter;

import model.person.Gender;
import model.person.Person;
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

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother){
        service.addPerson(firstName, lastName, gender, birthDate, deathDate, father, mother);

    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate){
        addPerson(firstName, lastName, gender, birthDate, deathDate, null, null);
    }

    public void getTreeInfo(){
        view.printAnswer(service.getInfo());
    }


    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }
}
