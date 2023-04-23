package Package.Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
   
    public String getSurname() {
        return surname;
    }
   
    public LocalDate getBirthDate() {
        return birthDate;
    }
   
    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person(Integer id, String name, String surname, LocalDate birthDate, LocalDate deathDate, Person father, Person mother) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Person(Integer id, String name, String surname, LocalDate birthDate, LocalDate deathDate) {
        this(id, name, surname, birthDate, deathDate, null, null);
    }

    public Person(Integer id, String name, String surname, LocalDate birthDate) {
        this(id, name, surname, birthDate, null, null, null);
    }

    public void addChildren(Person person) {
        if(!children.contains(person)) {
            children.add(person);
        }
    }

    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + surname + ", " + "дата рождения: " + birthDate +"\n");
        sb.append(fatherInfo() + "\n");
        sb.append(motherInfo() + "\n");
        sb.append(childrenInfo() + "\n");
        sb.append("\n");
        return sb.toString();
    }

    public String fatherInfo() {
        if (father == null) return "Отец: не указан";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Отец: " + father.getName() + " " + father.getSurname() + ", дата рождения: " + father.getBirthDate());
            return sb.toString();
        }
    }

    public String motherInfo() {
        if (mother == null) return "Мать: не указана";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Мать: " + mother.getName() + " " + mother.getSurname() + ", дата рождения: " + mother.getBirthDate());
            return sb.toString();
        }
    }

    public String childrenInfo() {
        if (children.size() == 0) return "Детей нет";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Дети: ");
            for(Person person: children) {
                sb.append(person.getName() + " " +
                        person.getSurname() +
                        ", дата рождения: " + person.getBirthDate() + "   ");
            }
            return sb.toString();
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.getId().equals(getId());
    }
}