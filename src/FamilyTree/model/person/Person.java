package FamilyTree.model.person;

import FamilyTree.model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person>, TreeItem<Person>  {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Person mother;
    private Person father;
    private List<Person> children;


    public Person(String name, Gender gender, LocalDate dateOfBirth, Person mother, Person father)
    {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Person(String name, Gender gender, LocalDate dateOfBirth)
    {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mother = null;
        this.father = null;
        children = new ArrayList<>();
    }

    public String getName() { return name; }

    public Gender getGender() { return gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public LocalDate getDateOfDeath() { return dateOfDeath; }

    public Person getMother() { return mother; };

    public Person getFather() { return father; }

    public List<Person> getChildren() { return children; }

    public void setName(String name) { this.name = name; }

    public void setGender(Gender gender) { this.gender = gender; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public void setDateOfDeath(LocalDate dateOfDeath) { this.dateOfDeath = dateOfDeath; }

    public void setMother(Person mother) { this.mother = mother; }

    public void setFather(Person father) { this.father = father; }

    public boolean addChild(Person child) {
        if(!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getPersonInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("Пол: ");
        sb.append(gender);
        sb.append(", ");
        sb.append("Дата рождения: ");
        sb.append(dateOfBirth);
        sb.append(", ");
        if(dateOfDeath != null) {
            sb.append("Дата смерти: ");
            sb.append(dateOfDeath);
            sb.append(", ");
        }
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if(mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if(father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if(children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
         } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.name);
    }
}


