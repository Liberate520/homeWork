package family_tree.presenter;

import family_tree.model.dog.Dog;
import family_tree.model.person.Person;
import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
    }

    void readTreeFromFile() {

    }
    public void createTreeOfPerson(){
        service = new Service<Person>();
    }
    public void createTreeOfDog(){
        service = new Service<Dog>();
    }
    void add() {}
    void sortByName() {}
    void sortByAge() {}
    void getTree() {}

}
