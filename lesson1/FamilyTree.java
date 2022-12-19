package lesson1;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.SyncResolver;

public class FamilyTree {
    private List<Human> humans;

    /**
     * создаение конструкторов
     */
    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumans() {
        return humans;
    }

    // ----------------------------------------------------
    /**
     * добавление
     */
    public void add(String n, String g, Human f, Human m) {
        Human human = new Human(n, g, f, m);
        humans.add(human);
    }


    /**
     * поиск по имени
     */
    public Human searchName(List<Human> humans, String a) {
        Human human = new Human();
        for (Human h : humans) {
            if (h.getName().equals(a)) {
                human = h;
            }
        }
        return human;
    }

    /**
     * печать всех
     */
    public void printHumans(List<Human> humans) {
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    /**
     * создание родственных связей
     */
    public void setRelative(Human a, Human b, Human c) {
        if (a.getGender().equals("муж") && b.getGender().equals("жен")) {
            c.setFather(a);
            c.setMother(b);
            a.getChildren().add(c);
            b.getChildren().add(c);
        } else if (a.getGender().equals("жен") && b.getGender().equals("муж")) {
            c.setFather(b);
            c.setMother(a);
            b.getChildren().add(c);
            a.getChildren().add(c);
        } else {
            System.out.println("Однополые браки запрещены!");
        }
    }

    /**
     * печать связи ребенок - родители
     */
    public void getRelative(List<Human> humans) {
        for (Human h : humans) {
            if (h.getFather() != null && h.getMother() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("имя: ")
                        .append(h.getName())
                        .append("\n" + "отец: ")
                        .append(h.getFather().getName())
                        .append("\n" + "мать: ")
                        .append(h.getMother().getName() + "\n");
                System.out.println(sb.toString());

            }
        }
    }
}
