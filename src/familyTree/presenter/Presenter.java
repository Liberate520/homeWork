package familyTree.presenter;


import familyTree.model.human.Gender;
import familyTree.model.service.*;
import familyTree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addToFamily(String name, LocalDate dateBirth, Gender gender){
        service.addToFamily(name, dateBirth, gender);
    }

    public void getFamilyInfo(){
        String answer = service.getFamilyInfo();
        view.printAnswer(answer);
    }
    public void sortByName(){
        service.sortByName();
        getFamilyInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyInfo();
    }
}
