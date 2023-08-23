package Presenter;

import Model.FamilyTree.Service;
import Model.Human.Gender;
import Model.Human.Status;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate date, Gender gender, Status status, LocalDate deathDate) {
        service.addHuman(name, date, gender, status, deathDate);
    }

    public void getInfo() {
        service.getInfoFamilyTree();
    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfo();
    }

    public void addHumanWithParents(String name, LocalDate date, Gender gender, Status status, int fatherId,
                                    int motherId, LocalDate deathDate) {
        service.addHumanWithParents(name, date, gender, status, fatherId,
                motherId, deathDate);
    }

    public void makeMarriage(int spouseOneId, int spouseTwoId) {
        service.makeMarriage(spouseOneId, spouseTwoId);
    }

    public void saveInfo() {
        service.saveInfo();
    }

    public void loadInfo() {
        service.loadInfo();
    }

    public void findById(int countInt) {
        service.findById(countInt);
    }

    public void addChild(int childId, int motherId, int fatherId) {
        service.addChildToParents(childId, motherId, fatherId);
    }
}
