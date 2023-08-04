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


    public void addParetns(int id, int ids) {
        service.addParents(id,ids);
        getInfo();
    }

    public void addChildren(int id, int ids) {
        service.addChildren(id,ids);
        getInfo();
    }

    public void addSpouse(int id, int ids) {
        service.addSpouse(id,ids);
        getInfo();
    }

    public void setDivorce(int id,int ids) {
        service.setDivorce(id,ids);
        getInfo();
    }

    public void getSiblings(int id) {
        service.getSiblings(id);
        getInfo();
    }
}
