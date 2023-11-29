package FamilyTreeItems.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import FamilyTreeItems.FamilyTreeItem;
import FamilyTreeItems.Sex;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {
    private long id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private FamilyTreeItem mother, father;
    private List<FamilyTreeItem> children;

    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father, List<FamilyTreeItem> children, LocalDate deathDate) {
        this.id = id; 
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.deathDate = deathDate;
    }
    
    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father, List<FamilyTreeItem> children) {
        this(id, firstName, lastName, birthDate, sex, mother, father, children, null);
    }

    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex, Human mother, Human father) {
        this(id, firstName, lastName, birthDate, sex, mother, father, new ArrayList<FamilyTreeItem>(), null);
    }

    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex, LocalDate deathDate) {
        this(id, firstName, lastName, birthDate, sex, null, null, new ArrayList<FamilyTreeItem>(), deathDate);
    }

    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex, LocalDate deathDate, List<FamilyTreeItem> children) {
        this(id, firstName, lastName, birthDate, sex, null, null, children, deathDate);
    }

    public Human(long id, String firstName, String lastName, LocalDate birthDate, Sex sex) {
        this(id, firstName, lastName, birthDate, sex, null, null, new ArrayList<FamilyTreeItem>(), null);
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Sex sex) {
        this(0, firstName, lastName, birthDate, sex, null, null, new ArrayList<FamilyTreeItem>(), null);
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public LocalDate getDeathDate() {
        return this.deathDate;
    }

    public FamilyTreeItem getFather() {
        return this.father;
    }

    public Sex getSex() {
        return this.sex;
    }

    public FamilyTreeItem getMother() {
        return this.mother;
    }

    public List<FamilyTreeItem> getChildren() {
        return this.children;
    }

    public boolean addChild(FamilyTreeItem child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            return true;
        }
        return false;
    }

    public boolean setDeathDate(LocalDate deathDate) {
        if (this.deathDate != null) {
            this.deathDate = deathDate;
            return true;
        }
        return false;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean setId(long id) {
        if (this.id == 0) {
            this.id = id;
            return true;
        }
        return false;
    }

    public boolean setMother(FamilyTreeItem mother) {
        if (this.mother == null) {
            this.mother = mother;
            return true;
        }
        return false;
    }

    public boolean setFather(FamilyTreeItem father) {
        if (this.father == null) {
            this.father = father;
            return true;
        }
        return false;
    }

    public int getChildrenAmount() {
        return this.children.size();
    }

    public int getAge() {
        LocalDate compareDate;
        if (this.deathDate == null) compareDate = LocalDate.now();
        else compareDate = this.deathDate;

        return Period.between(this.birthDate, compareDate).getYears();  
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        fullName.append(this.firstName).append(" ")
            .append(this.lastName);
        return fullName.toString();
    }

    public String getChildrenNames() {
        StringBuilder childrenNames = new StringBuilder();
        for (FamilyTreeItem child : this.children) {
            childrenNames.append(child.getFullName()).append("\n");
        }
        return childrenNames.toString();
    }
    
    private String getMotherInfo() {
        if (this.mother != null) return this.mother.getFullName();
        return "";
    }

    private String getFatherInfo() {
        if (this.father != null) return this.father.getFullName();
        return "";
    }

    private String getDeathDateInfo() {
        if (this.deathDate != null) return this.deathDate.toString();
        return "";
    }

    private String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ").append(this.id)
        .append("\nfirst name: ").append(this.firstName)
        .append("\nlast name: ").append(this.lastName)
        .append("\nsex: ").append(this.sex)
        .append("\nbirth date: ").append(this.birthDate.toString())
        .append("\ndeath date: ").append(this.getDeathDateInfo())
        .append("\nmother: ").append(this.getMotherInfo())
        .append("\nfather: ").append(this.getFatherInfo())
        .append("\nchildren: ").append(this.getChildrenNames()).append("\n");
        return info.toString();
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            Human e = (Human) obj;
            return this.id == e.getId();
        }
        return false;
    }

    @Override
    public int compareTo(Human o) {
        return o.getLastName().compareTo(this.lastName);
    }
}