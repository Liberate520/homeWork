package presenter;

import module.genealogicalTree.GenealogicalTree;
import module.human.Gender;
import module.human.Human;
import view.ConsoleUI;
import view.View;
import module.Service.*;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private static GenealogicalTree gTree;


    public Presenter(View view) {
        this.view = view;
        GenealogicalTree<Human> gTree;
        gTree = new GenealogicalTree<>();

    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
   //TODO создание нового человека, как определять родственные связи (можно через id)

        gTree.addHuman(new Human(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children));
        System.out.println("Adding successfully!");
        getInfo();
    }

    public void getInfo() {
        view.printAnswer(gTree.getInfo());
    }

    public void sortByAge() {
        gTree.sortByAge();
    }

    public void sortByName() {
        gTree.sortByName();
    }
}
