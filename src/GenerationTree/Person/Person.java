package GenerationTree.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import GenerationTree.Structs.Gender;
import GenerationTree.Tree.GenerationTree;
import GenerationTree.interfaces.GenTreeItem;
import GenerationTree.interfaces.Marrieble;

public class Person implements Marrieble, GenTreeItem<Person>, Comparable<Person> {

    private int id;
    private String name;
    private String sename;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setSename(GenerationTree<Person> family) {
        if (family.contains(this))
            this.sename = family.getTreeName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getSename() {
        return this.sename != null ? this.sename : "";
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

    public Boolean addChild(Person child) {
        if (child != null &&
                !this.equals(child) &&
                !this.children.contains(child)) {
            this.children.add(child);
            child.addParrent(this);
            if (this.sename != null &&
                    child.sename == null) {
                child.setSenameFromParrent(this.sename);
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

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    private void setSenameFromParrent(String sename) {
        this.sename = sename;
    }

}
