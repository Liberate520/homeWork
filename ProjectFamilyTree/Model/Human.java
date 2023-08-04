package homeWork.ProjectFamilyTree.Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements Serializable, Family_Tree_Item {
    private String name;
    private Human mother, father;
    private List<Human> children;
    private List<Human> sibling;
    private LocalDate localDateOfBirth;
    private LocalDate localDateofDeath;

    private Gender gender;

    public Human(String name, Human mother, Human father, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        sibling = new ArrayList<>();
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = localDateofDeath;
        this.gender = gender;

    }

    public Human(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender) {
        this.name = name;
        this.mother = null;
        this.father = null;
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = localDateofDeath;
        this.gender = gender;
        children = new ArrayList<>();
        sibling = new ArrayList<>();
    }
    public Human(String name, LocalDate localDateOfBirth, Gender gender) {
        this.name = name;
        this.mother = null;
        this.father = null;
        this.localDateOfBirth = localDateOfBirth;
        this.localDateofDeath = null;
        this.gender = gender;
        children = new ArrayList<>();
        sibling = new ArrayList<>();
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

    public List<Human> getSibling() {
        return sibling;
    }

    public String getSiblingInfo(){
        ArrayList list = new ArrayList<>();
        if(sibling.size() > 0){
            for (int i = 0; i < sibling.size(); i++) {
                list.add(sibling.get(i).getName());

            }
            return list.toString();
        }
        return "Отсутствуют";
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getLocalDateOfBirth() {
        return localDateOfBirth;
    }

    public LocalDate getLocalDateofDeath() {
        return localDateofDeath;
    }

    public int getAge() {
        int age;
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1;
        int d2;
        if (getLocalDateofDeath() == null) {
            d1 = Integer.parseInt(formatter.format(Date.from(Instant.from(getLocalDateOfBirth().atStartOfDay().atZone(ZoneId.systemDefault())))));
            d2 = Integer.parseInt(formatter.format(Date.from(Instant.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault())))));
            age = (d2 - d1) / 10000;
        } else {
            d1 = Integer.parseInt(formatter.format(Date.from(Instant.from(getLocalDateOfBirth().atStartOfDay().atZone(ZoneId.systemDefault())))));
            d2 = Integer.parseInt(formatter.format(Date.from(Instant.from(getLocalDateofDeath().atStartOfDay().atZone(ZoneId.systemDefault())))));
            age = (d2 - d1) / 10000;
        }
        return age;
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
        stringBuilder.append("; Brothers and Sisters: ");
        stringBuilder.append(getSiblingInfo());
        stringBuilder.append("; Birthday: ");
        stringBuilder.append(localDateOfBirth);
        if(localDateofDeath != null){
            stringBuilder.append("; Day of death: ");
            stringBuilder.append(localDateofDeath);
        }
        stringBuilder.append("; Age: ");
        stringBuilder.append(getAge());
        stringBuilder.append("; Gender: ");
        stringBuilder.append(gender);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
