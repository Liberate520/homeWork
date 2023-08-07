package presenter;

import model.Service.ServiceTree;
import model.genealogicalTree.GenealogicalTree;
import model.human.Gender;
import model.human.Human;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private ServiceTree family;


    public Presenter(View view) {
        this.view = view;
        family = new ServiceTree();

    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
   //TODO создание нового человека, как определять родственные связи (можно через id)
        try {
            family.addHuman(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
            System.out.println("Adding successfully!");
            getInfo();
        }catch (Exception e){
            System.out.println("Something has gone wrong in adding person to family");
        }
    }

    public void getInfo() {
        view.printAnswer(family.getHumanInfo());
    }

    public void sortByAge() {
        family.sortByAge();
    }

    public void sortByName() {
        family.sortByName();
    }
}
