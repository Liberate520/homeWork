package family_tree.creatures;

import family_tree.creatures.enums.Gender;
import family_tree.creatures.interfaces.Creatures;

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
    private Human mother, father, spouse;
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

    public long getAge() {
        long age;
        if (dateOfDeath != null) {
            age = ChronoUnit.YEARS.between(this.dateOfBirth, this.dateOfDeath);
        } else {
            age = ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
        }
        return age;
    }

    public String getLastName(){
        return this.lastName;
    }
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void addDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void addChildren(Human child) {
        if (this.children == null) {
            children = new LinkedList<Human>();
        }
        this.children.add(child);
    }

    public String viewGrandparents() {
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

    public String viewMother() {
        StringBuilder mother = new StringBuilder();
        if (this.mother != null) {
            mother.append("<Мать> \n" + this.mother.toString() + "\n");
        }
        return mother.toString();
        }

    public String viewFather() {
        StringBuilder father = new StringBuilder();
        if (this.father != null) {
            father.append("<Отец> \n" + this.father.toString() + "\n");
        }
        return father.toString();
    }

    public String viewSiblings(){
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

    public String viewSpouse() {
        StringBuilder spouse = new StringBuilder();
        if (this.spouse != null) {
            if (this.spouse.gender.toString().equals("Мужской")) {
                spouse.append("<Муж> \n" + this.spouse.toString() + "\n");
            } else {
                spouse.append("<Жена> \n" + this.spouse.toString() + "\n");
            }
        }
        return spouse.toString();
    }

    public String viewChildrens(){
        StringBuilder childrens = new StringBuilder();
        if (this.children != null) {
            childrens.append("<Дети>\n");
            for (Human child : this.children) {
                childrens.append(child.toString() + "\n");
            }
        }
        return childrens.toString();
    }

    public String viewGrandchildrens(){
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
                this.viewSpouse() +
                this.viewChildrens() +
                this.viewGrandchildrens();
    }

    public String toString () {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Имя: " + this.firstName +
                    "; Фамилия: " + this.lastName +
                    "; Пол: " + this.gender.toString() +
                    "; Возраст: " + this.getAge() + " лет" +
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

