package familyTree.src.family_tree.presenter;
import familyTree.src.family_tree.model.human.Gender;
import familyTree.src.family_tree.model.service.Service;
import familyTree.src.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String docId, String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                         String father, String mother, String spouse) {
        service.addHuman(docId, name, gender, birthDate, deathDate,
                father, mother, spouse);
        //TODO какой-то ответ
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}
