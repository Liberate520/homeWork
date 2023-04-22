import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String lastName;
    private Integer dateOfBirth;
    private Integer dateOfDeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human partner;
    private List<Human> children;

    public Human () {
        this.children = new ArrayList<Human>();
    }

    public Human(String name, String lastName, Integer dateOfBirth, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<Human>();
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (!mother.getChildren().contains(this)) {
            mother.addChild(this);
        }
    }

    public void setFather(Human father) {
        this.father = father;
        if (!father.getChildren().contains(this)) {
            father.addChild(this);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfDeath(Integer dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
        if (partner.getPartner() == null) {
            partner.setPartner(this);
        }
    }

    public void addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        parents.add(this.mother);
        parents.add(this.father);
        return parents;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getPartner() {
        return partner;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getGeneralInfo() {
        String separ = ", ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        stringBuilder.append(this.getName());
        stringBuilder.append(separ);
        stringBuilder.append(this.getLastName());
        stringBuilder.append(separ);
        stringBuilder.append(this.getDateOfBirth());
        stringBuilder.append(separ);
        stringBuilder.append(this.getGender());
        stringBuilder.append(separ);
        stringBuilder.append("mother: ");
        if (this.mother != null) {stringBuilder.append(this.mother.getGeneralInfo());}
        else {stringBuilder.append(" ---- ");}
        stringBuilder.append(separ);
        stringBuilder.append("father: ");
        if (this.father != null) {stringBuilder.append(this.father.getGeneralInfo());}
        else {stringBuilder.append(" ---- ");}
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
