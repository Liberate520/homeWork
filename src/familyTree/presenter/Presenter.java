package familyTree.presenter;


import familyTree.model.human.Gender;
import familyTree.model.human.Human;
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

    public void addToFamily(String name, LocalDate dateBirth, Gender gender) {
        service.addToFamily(name, dateBirth, gender);
    }

    public void setParents(long idChild, long idMother, long idFather) {
        service.setParents(idChild, idMother, idFather);
        getFamilyInfo();
    }

    public void getFamilyInfo() {
        String answer = service.getFamilyInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getFamilyInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyInfo();
    }

    public void writeFile(String filePath) {
        service.writeSerialization(filePath);
    }

    public void readFile(String filePath) {
        String dataRead = "Read files :\n" + service.readSerialization(filePath);
        view.printAnswer(dataRead);
    }
}
