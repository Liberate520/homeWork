import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
//    private long id;
    private Human mother, father;
    private List<Human> children;
    private Gender gender;

    public Human(String name, Gender gender, Human mother, Human father) {
//        id = -1;
        this.name = name;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender) { // без родителей
        this(name, gender, null, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public boolean addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public List<String> getParents() {
        List<String> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father.name);
        }
        if (mother != null) {
            list.add(mother.name);
        }
        return list;
    }


    private String getInfo() {
        StringBuilder sb = new StringBuilder();
//        sb.append("id: ");
//        sb.append(id);
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getGender());
        sb.append(", родители: ");
        sb.append(getParents());
        sb.append(", дети:");
        sb.append(getChildren());

        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
