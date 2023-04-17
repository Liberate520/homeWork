
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {

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
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ").append(name).append(" ").append(birthday).append("-").append(deathDay).append("\n");
        if(father != null){
            sb.append("отец: ").append(father.getName()).append("\n");
        }
        if(mother != null){
           sb.append("мать: ").append(mother.getName()).append("\n");
        }
        if(spouse != null){
            sb.append("супруг(а): ").append(spouse.getName()).append("\n");
        }
        sb.append("дети: ").append(getChildren()).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Human o) {
        return -1 * (birthday - o.birthday);
    }
}
