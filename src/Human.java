
import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;

    private int birthday;
    private int deathDay;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human>children;

    public Human(String name, int birthday, int deathDay) {

        this.name = name;
        this.birthday = birthday;
        this.deathDay = deathDay;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void addChildren(Human child) {
        children.add(child);
    }

    public List<String> getChildren() {
        List<String> result = new ArrayList<>();
        for (Human item:
             children) {
            result.add(item.name);
        }
        return result;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getDeathDay() {
        return deathDay;
    }

    @Override
    public String toString() {
        return "имя: " + name + "\n" +
                birthday + " - " +
                deathDay + "\n" +
                "отец: " + father.getName() + "\n" +
                "мать: " + mother.getName() + "\n" +
                "супруг(а): " + spouse.getName() + "\n" +
                "дети: " + getChildren();
    }
}
