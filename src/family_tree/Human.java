package family_tree;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Human {
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

    public String viewFamily() {
        StringBuilder grandparents = new StringBuilder();
        StringBuilder parents = new StringBuilder();
        StringBuilder siblings = new StringBuilder();
        StringBuilder spouse = new StringBuilder();
        StringBuilder childrens = new StringBuilder();
        StringBuilder grandchildrens = new StringBuilder();
        if (this.mother != null) {
            if (this.mother.mother != null) {
                grandparents.append(this.mother.mother.toString() + "\n");
            }
            if (this.mother.father != null) {
                grandparents.append(this.mother.father.toString() + "\n");
            }
            if (this.mother.children != null){
                for (Human sibling : this.mother.children){
                    if (this.id != sibling.id){
                        siblings.append(sibling.toString() + "\n");
                    }
                }
            }
            parents.append("<Мать> " + this.mother.toString() + "\n");
        }
        if (this.father != null) {
            if (this.father.mother != null) {
                grandparents.append(this.father.mother.toString() + "\n");
            }
            if (this.father.father != null) {
                grandparents.append(this.father.father.toString() + "\n");
            }
            parents.append("<Отец> " + this.father.toString() + "\n");
        }

        if (this.spouse != null) {
            if (this.spouse.gender.toString().equals("Мужской")) {
                spouse.append("<Муж> " + this.spouse.toString() + "\n");
            } else {
                spouse.append("<Жена> " + this.spouse.toString() + "\n");
            }
        }

        if (this.children != null) {
            childrens.append("<Дети>\n");
            for (Human child : this.children) {
                childrens.append(child.toString() + "\n");
            }
            for (Human child : this.children) {
                if (child.children != null) {
                    for (Human grandchild : child.children) {
                        grandchildrens.append(grandchild.toString() + "\n");
                    }
                }
            }
        }
        if (!grandparents.isEmpty()){
            grandparents.insert(0,"<Бабушки и дедушки>\n");
        }
        if (!grandchildrens.isEmpty()){
            grandchildrens.insert(0,"<Внуки и внучки>\n");
        }
        if (!siblings.isEmpty()){
            siblings.insert(0,"<Братья и сестры>\n");
        }
        return grandparents.toString() + parents.toString() + siblings.toString() + spouse.toString() + childrens.toString() + grandchildrens.toString();
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
    }

