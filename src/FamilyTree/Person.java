package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import FamilyTree.Structs.Gender;
import FamilyTree.interfaces.Marrieble;

public class Person implements Marrieble, Serializable {

    private int id;
    private String name;
    private FamilyTree family;
    private Gender gender;
    private Marrieble spouse;

    private LocalDate dateBirth;
    private LocalDate dateOfMarriage;
    private LocalDate dateDaeth;
    private List<Person> parrents;
    private List<Person> children;

    public Person(int id, String name, Gender gender, LocalDate dateBirth) {
        this(id, name, gender, dateBirth, null);
    }

    public Person(int id, String name, Gender gender, LocalDate dateBirth, LocalDate dateDaeth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.spouse = null;
        this.dateBirth = dateBirth;
        this.dateDaeth = dateDaeth;
        this.parrents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getSename() {
        return this.family != null ? this.family.getSename() : "";
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public LocalDate getDateOfMarriage() {
        return this.dateOfMarriage;
    }

    public LocalDate getdateDaeth() {
        return this.dateDaeth;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Person> getParrents() {
        return parrents;
    }

    public FamilyTree getFamilyTree() {
        return this.family;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFamily(FamilyTree family) {
        this.family = family;
    }

    public Boolean addChild(Person child) {
        if (child != null &&
                !this.equals(child) &&
                !this.children.contains(child)) {
            this.children.add(child);
            child.addParrent(this);
            if (this.family != null &&
                    child.family == null) {
                child.setFamily(this.family);
            }
            if (this.spouse != null) {
                spouse.addChild(child);
            }
            return true;
        }
        return false;
    }

    public void addParrent(Person child) {
        parrents.add(child);
    }

    @Override
    public Boolean addSpouse(Marrieble spouse, LocalDate dateOfMarriage) {
        if (spouse != null &&
                !this.equals(spouse) &&
                (this.spouse == null || !this.spouse.equals(spouse))) {
            this.spouse = spouse;
            this.dateOfMarriage = dateOfMarriage;
            spouse.addSpouse(this, dateOfMarriage);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            var another = (Person) obj;
            return this.name.equals(another.name) &&
                    this.gender.equals(another.gender) &&
                    this.dateBirth == another.dateBirth &&
                    this.dateDaeth == another.dateDaeth &&
                    this.parrents.equals(another.parrents) &&
                    this.children.equals(another.children);
        }
        return false;
    }

    @Override
    public String toString() {
        return name
                + (getSename().isEmpty() ? "" : " " + getSename())
                + ", пол: " + this.gender + ", дата рождения: " + dateBirth
                + (this.dateDaeth != null ? "Дата смерти:" + this.dateDaeth : "");
    }

}
