package fam_tree.valet.comands;

import fam_tree.human.Gender;
import fam_tree.human.HumanBuild;
import fam_tree.valet.Look;
import fam_tree.valet.Valet;

import java.time.LocalDate;

public class Presenter {
    private final Look look;
    private final Valet valet;

    public Presenter(Look look) {
        this.look = look;
        valet = new Valet();
    }

    public boolean addHumanToTheFamily(String name, Gender gender, LocalDate birthday) {
        valet.addHumanToTheFamily(name, gender, birthday);
//        getTreeInfo();
        return true;
    }


    public void getTreeInfo() {
        String answer = valet.getTreeInfo();
        look.answer(answer);
    }

    public void sortByAge() {
        valet.sortByAge();
        getTreeInfo();
    }

    public void sortByName() {
        valet.sortByName();
        getTreeInfo();
    }



}
