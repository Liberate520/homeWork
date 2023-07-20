package family_tree.presenter;

import family_tree.model.dog.Dog;
import family_tree.model.gender.Gender;
import family_tree.model.person.Person;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    final String path = "src/familyTree.out";

    public Presenter(View view) {
        this.view = view;
    }

    public void readTreeOfPersonFromFile() {
        service = new Service<Person>("Person");
        service.readTreeFromFile(path);
    }

    public void createTreeOfPerson() {
        service = new Service<Person>("Person");
    }

    public void createTreeOfDog() {

        service = new Service<Dog>("Dog");
    }

    public void addItem(String name,
                        LocalDate birthday,
                        LocalDate dayOfDeath,
                        Gender gender) {
        service.add(name, birthday, dayOfDeath, gender);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void printTree() {
        service.print();
    }

    public void saveTree() {
        service.saveTreeInFile(path);
    }
}
