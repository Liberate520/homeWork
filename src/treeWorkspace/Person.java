package treeWorkspace;

import enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable,Comparable<Person>, TreeItem<Person> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private int age;
    private List<Person> parentsList;
    private List<Person> childrenList;

    public Person(int id, String name, Gender gender, LocalDate birthDate) {
        parentsList = new ArrayList<>() {
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Person person : parentsList) {
                    sb.append(person.getName());
                    sb.append(" ");
                    sb.append(person.getGender());
                    sb.append(",");
                }
                return sb.toString();
            }
        };
        childrenList = new ArrayList<>() {
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Person person : childrenList) {
                    sb.append(person.getName());
                    sb.append(" ");
                    sb.append(person.getGender());
                    sb.append(",");
                }
                return sb.toString();
            }
        };
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Person(int id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(id, name, gender, birthDate);
        this.deathDate = deathDate;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", age=" + getAge() +
                "\n, parentsList=" + parentsList +
                "\n, childrenList=" + childrenList +"\n"+
                "=".repeat(130);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return deathDate == null ?
                LocalDate.now().getYear() - birthDate.getYear()
                : deathDate.getYear() - birthDate.getYear();
    }

    public Person addChildren(Person child) {
        if (!childrenList.contains(child)) {
            childrenList.add(child);
            child.parentsList.add(this);
        }
        return this;
    }

    public Person addParent(Person parent) {
        if (!parentsList.contains(parent)){
            parentsList.add(parent);
            parent.childrenList.add(this);
        }
        return this;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }
}
