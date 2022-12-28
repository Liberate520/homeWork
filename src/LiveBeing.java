
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class LiveBeing<T extends LiveBeing<T>> implements Serializable, Comparable<T> {
    private String name;
    private int date;
    private String sex;
    private T father;
    private T mother;
    private List<T> children;

    public LiveBeing(String name, int date, String sex) {
        this.name = name;
        this.date = date;
        this.sex = sex;
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public LiveBeing(String name) {
        this.name = name;
        this.date = generateNowDate();
        this.sex = getRandomSex();
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getDate() {
        return this.date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(T father) {
        this.father = father;
    }

    public void setMother(T mother) {
        this.mother = mother;
    }

    public List<T> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        if (this.father == null && this.mother == null && this.children == null)
            return String.format(
                    "Object type: %s\nname: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: NaN\n",
                    this.getClass().getName(), this.name, this.date, this.sex, this.father, this.mother);
        else if (this.father == null && this.mother == null)
            return String.format("Object type: %s\nname: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.getClass().getName(), this.name, this.date, this.sex, this.father, this.mother, this.children);
        else if (this.father == null)
            return String.format("Object type: %s\nname: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.getClass().getName(), this.name, this.date, this.sex, this.father, this.mother.getName(),
                    this.children);
        else if (this.mother == null)
            return String.format("Object type: %s\nname: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.getClass().getName(), this.name, this.date, this.sex, this.father.getName(), this.mother,
                    this.children);
        else
            return String.format("Object type: %s\nname: %s, date: %s, sex: %s\nFather: %s\nMother: %s\nChildren: %s\n",
                    this.getClass().getName(), this.name, this.date, this.sex, this.father.getName(),
                    this.mother.getName(),
                    this.children.toString().replaceAll("\\[\\]", ""));
    }

    private int generateNowDate() {
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

    @Override
    public int compareTo(T o) {
        return name.compareTo(((T) o).getName());
    }
}
