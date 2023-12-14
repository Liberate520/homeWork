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

    public boolean addHumanInTree(String name, Gender gender,LocalDate localDate){
        service.addHumanInTree(name,gender,localDate);
        return true;
    }

    public void printAllTree() {
        service.printAllTree();
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }
}
