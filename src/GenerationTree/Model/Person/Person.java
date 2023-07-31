package GenerationTree.Model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import GenerationTree.Model.Person.Structs.Gender;
import GenerationTree.Model.Tree.GenTreeItem;
import GenerationTree.Model.Tree.GenerationTree;

public class Person implements Marrieble, GenTreeItem, Comparable<Person> {

    private int id;
    private String name;
    private String surname;
    private Gender gender;
    private Marrieble spouse;

    private LocalDate dateBirth;
    private LocalDate dateOfMarriage;
    private LocalDate dateDaeth;
    private List<GenTreeItem> parrents;
    private List<GenTreeItem> children;

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

    public void setSurname(GenerationTree family) {
        if (family.contains((GenTreeItem) this))
            this.surname = family.getTreeName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname != null ? this.surname : "";
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

    public List<GenTreeItem> getChildren() {
        return this.children;
    }

    public List<GenTreeItem> getParrents() {
        return parrents;
    }

    public Boolean addChild(Person child) {
        if (child != null &&
                !this.equals(child) &&
                !this.children.contains(child)) {
            this.children.add(child);
            child.addParrent(this);
            if (this.surname != null &&
                    child.surname == null) {
                child.setSenameFromParrent(this.surname);
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
    public boolean isAncestor(GenTreeItem potentialAncestor) {
        if (this == potentialAncestor) {
            return true;
        }
        for (var parent : this.parrents) {
            if (parent.isAncestor(potentialAncestor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDescendant(GenTreeItem potentialDescendant) {
        if (this == potentialDescendant) {
            return true;
        }
        for (GenTreeItem child : this.children) {
            if (child.isDescendant(potentialDescendant)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(GenTreeItem person) {
        return this.children.remove(person) && this.parrents.remove(person);
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
                + (getSurname().isEmpty() ? "" : " " + getSurname())
                + ", пол: " + this.gender + ", дата рождения: " + dateBirth
                + (this.dateDaeth != null ? "Дата смерти:" + this.dateDaeth : "");
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    private void setSenameFromParrent(String sename) {
        this.surname = sename;
    }

}
