package genealogy_tree.presenter;

import genealogy_tree.model.Human.Gender;
import genealogy_tree.model.Human.Human;
import genealogy_tree.model.service.Service;
import genealogy_tree.ui.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view ){
        this.view = view;
        service = new Service();
    }
    public void addHuman(int id, String name, Gender gender, LocalDate birthDate){
        service.addHuman(id, name,gender,birthDate);
        getInfo();
    }
    public void getInfo(){
        String answer = service.getInfo();
        view.printAnswer(answer);
    }
    public void sortByAge(){
        service.sortByAge();
        getInfo();
    }
    public void sortByName(){
        service.sortByName();
        getInfo();
    }


    public void addParetns() {
        service.addParents();
        getInfo();
    }

    public void addChildren() {
        service.addChildren();
        getInfo();
    }

    public void addSpouse() {
        service.addSpouse();
        getInfo();
    }

    public void setDivorce() {
        service.setDivorce();
        getInfo();
    }

    public void getSiblings() {
        service.getSiblings();
        getInfo();
    }
}
