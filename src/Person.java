package family_tree;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;

public class Person {
    private String inn;
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private LocalDate dataMort;
    private Gender gender;
    private Person father;
    private Person mother;
    private Person husband;
    private HashSet<Person> children;

    public Person(String fName, String lName, Gender gen, LocalDate dataB, LocalDate dataM) {
        this.firstName = fName;
        this.lastName = lName;
        this.gender = gen;
        this.dataBirth = dataB;
        this.dataMort = dataM;
        this.father = null;
        this.mother = null;
        children = new HashSet<>();
    }

    public Person(String fName, String lName, Gender gen, LocalDate dataB) {
        this(fName, lName, gen, dataB, null);

    }

    public void setParents(Person fParent, Person sParent) {
        if (fParent.gender == sParent.gender) {
            System.out.println("неверно указаны родители");
        } else {
            this.addParent(fParent);
            this.addParent(sParent);
            fParent.addChildren(this);
            sParent.addChildren(this);

        }
    }

    public void addChildren(Person children) {

        this.children.add(children);
    }

    public void addParent(Person parent) {
        if ((parent.gender == Gender.Female) && (this.mother == null)) {
            this.mother = parent;
        }
        if ((parent.gender == Gender.Male) && (this.father == null)) {
            this.father = parent;
        }

    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(this.firstName);
        info.append(' ');
        info.append(this.lastName);

        return new String(info);
    }

    public String getFullInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Full name: ");
        info.append(this.firstName);
        info.append(' ');
        info.append(this.lastName);
        info.append(", date birth: ");
        info.append(this.dataBirth);
        if (!(this.dataMort == null)) {
            info.append(", date mort: ");
            info.append(this.dataMort);
        }
        info.append(", parents: ");
        info.append(this.getListParent());


        return new String(info);
    }

    public HashSet<Person> getChildren() {
        return this.children;

    }

    public String getListChildren() {


        if (this.children == null) {
            return "there are no children";
        } else {
            StringBuilder info = new StringBuilder();
            for (Person item : this.children) {
                info.append(item.getFullInfo());
                info.append("\n");
            }
            return new String(info);
        }
    }


    public String getListParent() {
        StringBuilder info = new StringBuilder();
        info.append("father: ");
        info.append(this.father.getInfo());
        info.append(", mother: ");
        info.append(this.mother.getInfo());

        return new String(info);
    }

    public Gender Gender() {
        return this.gender;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }


    public boolean marriage(Person partner) {
        if ((this.gender != partner.gender)
                && (this.husband == null) && (partner.husband == null)) {
            this.husband = partner;
            partner.husband = this;
            return true;
        }
        return false;
    }

    public boolean divorce(Person partner) {
        if (this.husband == partner.husband) {
            this.husband = null;
            partner.husband = null;
            return true;
        }
        return false;
    }


}
