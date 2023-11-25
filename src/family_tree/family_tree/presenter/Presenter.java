package family_tree.family_tree.presenter;

import family_tree.family_tree.model.FamilyTree;
import family_tree.family_tree.model.Gender;
import family_tree.family_tree.model.service.Service;
import family_tree.family_tree.view.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {

        this.view = view;
        int index = 0;                                    // ???
        FamilyTree familyTree = null;                     // ???
        service = new Service(index, familyTree);         // ???
    }

    // Уточнить метод, - переделать !!!
//    public void addHuman(String name, int age) {
//        service.addHuman(name, age);
//        view.answer("Человек добавлен");
    public void addHuman(String name, LocalDate birthDate, Gender gender){
      //  LocalDate birthDate = null; // ??
//        service.addHuman(name, birthDate, deathDate, gender);
        service.addHuman(name, gender, birthDate);
        getHumanListInfo();

    }

    public void getHumanListInfo() {
//        String answer = service.getHumanListInfo();
        String answer = null;
        view.answer(answer);
    }

    public void sortByName() {
//        service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
//        service.sortByAge();
        getHumanListInfo();
    }
}
