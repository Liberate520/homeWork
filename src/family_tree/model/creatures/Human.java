package family_tree.model.creatures;

import family_tree.model.creatures.enums.Gender;
import family_tree.model.creatures.interfaces.Creatures;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, Creatures {
    private int id;
    private String firstName, lastName;
    private LocalDate dateOfBirth, dateOfDeath;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public Human(int id, String firstName, String lastName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Human(int id, String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
    }

    public int getId(){
        return this.id;
    }

    public long getAge() {
        long age  = 0;
        if (dateOfDeath != null) {
            age = ChronoUnit.YEARS.between(this.dateOfBirth, this.dateOfDeath);
        } else {
            age = ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
        }
        return age;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setMother(Creatures mother) {
        this.mother = (Human) mother;
        mother.addChildren(this);
    }

    public void setFather(Creatures father) {
        this.father = (Human) father;
        father.addChildren(this);
    }

    public void addChildren(Creatures child) {
        if (this.children == null) {
            children = new LinkedList<Human>();
        }
        this.children.add((Human) child);
    }

    private String viewGrandparents() {
        StringBuilder grandparents = new StringBuilder();
        if (this.mother != null) {
            if (this.mother.mother != null) {
                grandparents.append(this.mother.mother.toString() + "\n");
            }
            if (this.mother.father != null) {
                grandparents.append(this.mother.father.toString() + "\n");
            }

        }
        if (this.father != null) {
            if (this.father.mother != null) {
                grandparents.append(this.father.mother.toString() + "\n");
            }
            if (this.father.father != null) {
                grandparents.append(this.father.father.toString() + "\n");
            }
        }
        if (!grandparents.isEmpty()){
            grandparents.insert(0,"<Бабушки и дедушки>\n");
        }
        return grandparents.toString();
    }

    private String viewMother() {
        StringBuilder mother = new StringBuilder();
        if (this.mother != null) {
            mother.append("<Мать> \n" + this.mother.toString() + "\n");
        }
        return mother.toString();
        }

    private String viewFather() {
        StringBuilder father = new StringBuilder();
        if (this.father != null) {
            father.append("<Отец> \n" + this.father.toString() + "\n");
        }
        return father.toString();
    }

    private String viewSiblings(){
        StringBuilder siblings = new StringBuilder();
        if (this.mother != null) {
            if (this.mother.children != null){
                for (Human sibling : this.mother.children){
                    if (this.id != sibling.id){
                        siblings.append(sibling.toString() + "\n");
                    }
                }
            }
        }
        if (!siblings.isEmpty()){
            siblings.insert(0,"<Братья и сестры>\n");
        }
        return siblings.toString();
    }

    private String viewChildrens(){
        StringBuilder childrens = new StringBuilder();
        if (this.children != null) {
            childrens.append("<Дети>\n");
            for (Human child : this.children) {
                childrens.append(child.toString() + "\n");
            }
        }
        return childrens.toString();
    }

    private String viewGrandchildrens(){
        StringBuilder grandchildrens = new StringBuilder();
        if (this.children != null) {
            for (Human child : this.children) {
                if (child.children != null) {
                    for (Human grandchild : child.children) {
                        grandchildrens.append(grandchild.toString() + "\n");
                    }
                }
            }
        }
        if (!grandchildrens.isEmpty()){
            grandchildrens.insert(0,"<Внуки и внучки>\n");
        }
        return grandchildrens.toString();
    }

    public String viewAllFamily(){
        return this.viewGrandparents() +
                this.viewMother() +
                this.viewFather() +
                this.viewSiblings() +
                this.viewChildrens() +
                this.viewGrandchildrens();
    }

    public String toString () {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ID: " + this.id +
                    "; Имя: " + this.firstName +
                    "; Фамилия: " + this.lastName +
                    "; Пол: " + this.gender.toString() +
                    "; Возраст: " + this.getAge() +
                    "; Дата рождения: " + this.dateOfBirth);
            if (this.dateOfDeath != null) {
                stringBuilder.append("; Дата смерти: " + this.dateOfDeath + ";");
            }
            return stringBuilder.toString();
        }
    public int compareTo(Human o) {
        return this.firstName.compareTo(o.firstName);
    }
}

