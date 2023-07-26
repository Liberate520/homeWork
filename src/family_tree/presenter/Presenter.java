package family_tree.presenter;

import family_tree.model.gender.Gender;
import family_tree.model.service.ReadTree;
import family_tree.model.service.Service;
import family_tree.model.service.ServiceDog;
import family_tree.model.service.ServicePerson;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;



    public Presenter(View view) {
        this.view = view;
    }

    public void readTreeOfPersonFromFile() {
         ReadTree readTree  = new ReadTree();
         service = readTree.read();
//         service = new ServicePerson();
         service.readTreeFromFile();

    }

    public void createTreeOfPerson() {

        service = new ServicePerson();
    }

    public void createTreeOfDog() {

        service = new ServiceDog();
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
        service.saveTreeInFile();
    }
}
