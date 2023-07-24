package homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate localDateOfBirth;
    private LocalDate localDateofDeath;

    private Gender gender;

    public Human(String name, Human mother, Human father, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = localDateofDeath;
        this.gender = gender;

    }

    public Human(String name, LocalDate localDateOfBirth, Gender gender) {
        this.name = name;
        this.mother = null;
        this.father = null;
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = null;
        this.gender = gender;
        children = new ArrayList<>();
    }
    public Human(String name, Human mother, Human father, LocalDate localDateOfBirth, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = null;
        this.gender = gender;
    }

    public String getName() {
        String res = "";
        if(name.equals(null)){
            res += "Неизвестно";
        } else {
            res += name;
        }
        return res;
    }

    public Human getFather() {
        return father;
    }
    public String getFatherName() {
        if (father == null){
            return "Отсутствует";
        }
        return father.getName();
    }
    public Human getMother() {
        return mother;
    }
    public String getMotherName() {
        if (mother == null){
            return "Отсутствует";
        }
        return mother.getName();
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }
    public String getChildrenInfo(){
        ArrayList list = new ArrayList<>();
        if(children.size() > 0){
            for (int i = 0; i < children.size(); i++) {
                list.add(children.get(i).getName());

        }
            return list.toString();
        }
        return "Отсутствуют";
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {

        /*return "Name: " + "\nMother: " + mother + "\nFather: " + father + "\nChildren(s): " + children + "\nDay of Birth: " + localDateOfBirth +
                "\nGender: " + gender;*/
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(getName());
        stringBuilder.append("; Mother: ");
        stringBuilder.append(getMotherName());
        stringBuilder.append("; Father: ");
        stringBuilder.append(getFatherName());
        stringBuilder.append("; Children: ");
        stringBuilder.append(getChildrenInfo());
        stringBuilder.append("; Birthday: ");
        stringBuilder.append(localDateOfBirth);
        stringBuilder.append("; Day of death: ");
        stringBuilder.append(localDateofDeath);
        stringBuilder.append("; Gender: ");
        stringBuilder.append(gender);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
