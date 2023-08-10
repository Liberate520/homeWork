package family_tree;

import java.time.LocalDate;
import java.util.HashSet;


public class Person {
    private int inn;
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private LocalDate dataMort;
    private Gender gender;
    private Person father;
    private Person mother;
    private Person husband;
    private HashSet<Person> children;


    public Person(String fName, String lName, Gender gen, LocalDate dataB, LocalDate dataM, int innP) {
        this.firstName = fName;
        this.lastName = lName;
        this.gender = gen;
        this.dataBirth = dataB;
        this.dataMort = dataM;
        this.father = null;
        this.mother = null;
        children = new HashSet<>();
        this.inn = innP;
    }

    public Person(String fName, String lName, Gender gen, LocalDate dataB) {
        this(fName, lName, gen, dataB, null, 0);

    }

    public void setInn(int valueInn) {
        this.inn = valueInn;
    }

    public int getInn() {
        return this.inn;
    }

    //TODO доработать для одного родителя
    public void setParents(Person fParent, Person sParent) {
        if ((fParent != sParent) && (fParent.gender == sParent.gender)) {
            System.out.println("неверно указаны родители");
        } else {
            this.addParent(fParent);
            this.addParent(sParent);
            fParent.addChildren(this);
            sParent.addChildren(this);

        }
    }

    public void setParents(Person Parent) {
        this.setParents (Parent, Parent);
    }

    private void addChildren(Person children) {

        this.children.add(children);
    }

    private void addParent(Person parent) {
        if ((this.mother == null)&&(parent.gender == Gender.Female)) {
            this.mother = parent;
        }
        if ((this.father == null)&& (parent.gender == Gender.Male)) {
            this.father = parent;
        }

    }

    public String getInfo() {
        return String.join(" ", this.firstName, this.lastName);
    }

    public String getFullInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Full name: ");
        info.append(this.getInfo());
        info.append(", INN: ");
        info.append(this.inn);
        info.append(", date birth: ");
        info.append(this.dataBirth);
        if (!(this.dataMort == null)) {
            info.append(", date mort: ");
            info.append(this.dataMort);
        }
        info.append(", parents: ");
        info.append(this.getListParent());
        info.append(",  husband: ");
        info.append(this.husband != null ? this.husband.getInfo() : "NON");


        return new String(info);
    }

    public String getString() {
        StringBuilder info = new StringBuilder();
        info.append(this.inn);
        info.append(" ");
        info.append(this.getInfo());
        info.append(" ");
        info.append(this.gender);
        info.append(" ");
        info.append(this.dataBirth);
        info.append(" ");
        info.append(this.dataMort);
        info.append(" ");
        info.append(this.father != null ? this.father.inn : "null");
        info.append(" ");
        info.append(this.mother != null ? this.mother.inn : "null");
        info.append(" ");
        info.append(this.husband != null ? this.husband.inn : "null");

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
        info.append(this.father == null ? "unknown" : this.father.getInfo());
        info.append(", mother: ");
        info.append(this.mother == null ? "unknown" : this.mother.getInfo());

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

    public Person getHusband() {
        return this.husband;
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
