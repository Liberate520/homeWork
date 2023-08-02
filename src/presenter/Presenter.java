package presenter;

import module.genealogicalTree.GenealogicalTree;
import module.human.Gender;
import module.human.Human;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private  GenealogicalTree gTree;


    public Presenter(View view) {
        this.view = view;
        gTree = new GenealogicalTree<>();

    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
   //TODO создание нового человека, как определять родственные связи (можно через id)
        try {
            gTree.addHuman(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
            System.out.println("Adding successfully!");
            getInfo();
        }catch (Exception e){
            System.out.println("Something has gone wrong in adding person to family");
        }
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
