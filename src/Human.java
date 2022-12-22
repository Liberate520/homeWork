import java.time.Year;
import java.util.*;

public class Human {
    private String name;
    private int date;
    private String sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, int date, String sex) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public Human(String name) {
        this.name = name;
        this.date = getDate();
        this.sex = getRandomSex();
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        if (this.father == null && this.mother == null && this.children == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: NaN\n",
                    this.name, this.date, this.sex, this.father, this.mother);
        else if (this.father == null && this.mother == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father, this.mother, this.children);
        else if (this.father == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father, this.mother.getName(), this.children);
        else if (this.mother == null)
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father.getName(), this.mother, this.children);
        else
            return String.format("name: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.name, this.date, this.sex, this.father.getName(), this.mother.getName(),
                    this.children.toString().replaceAll("\\[\\]", ""));
    }

    private int getDate() {
        int date = Year.now().getValue();
        return date;
    }

    private String getRandomSex() {
        Random random = new Random();
        int rnd = random.nextInt(0, 2);
        if (rnd == 0)
            return "female";
        else
            return "male";
    }
}