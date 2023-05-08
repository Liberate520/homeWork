package Package.Presenter;

import Package.Model.Tree.Person;
import Package.Model.Tree.Service;
import Package.View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showTree(){
        service.showTree();
    }
    public void addPerson(String name, String surname, LocalDate birthDate, LocalDate deathDate, Integer fatherId, Integer motherId){
        service.addMember(name, surname, birthDate, deathDate, fatherId, motherId);
    }
    public void deletePerson(int id){
        service.deleteMember(id);
    }

    public int getSize() {
        return service.getSize();
    }

    public void save() throws IOException {
        service.save();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortBySurname() {
        service.sortBySurname();
    }

    public void sortByBirthdate() {
        service.sortByBirthdate();
    }
}
