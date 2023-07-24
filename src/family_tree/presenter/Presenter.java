package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.E;
import family_tree.model.human.Gender;

import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree familyTree;


    public Presenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();

    }

    public void getInfo() {
        view.printAnswer(familyTree.getInfo());

    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        E human = new E(name, gender, birthDate);
        familyTree.add(human);
        getInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
        getInfo();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        getInfo();
    }
}
