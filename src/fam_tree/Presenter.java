package fam_tree;

import java.time.LocalDate;

public class Presenter {
    private final Look look;
    private final Valet valet;

    public Presenter(Look look) {
        this.look = look;
        valet = new Valet();
    }

    public void addHumanToTheFamily(String name, Gender gender, LocalDate birthday) {
        valet.addHumanToTheFamily(name, gender, birthday);
        getTreeInfo();
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
