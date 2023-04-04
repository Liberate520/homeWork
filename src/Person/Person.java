package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Person
 */
public class Person implements Serializable{
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> childrens;

    public Person(int id, String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Person mother,
            Person father,
            List<Person> childrens) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.childrens = childrens;
    }

    public Person() {
        this(0, null, null, null, null, null, null, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("\n").append(id).append(", имя: ").append((name)).append(", дата рождения: ").append(birthDate);
        if (deathDate == null)
            sb = sb.append(", возраст: ").append(getAge());
        else
            sb = sb.append(", дата смерти: ").append(deathDate);
        if (mother == null)
            sb = sb.append(", мать не определена");
        else
            sb = sb.append(", мать: ").append(mother.getName());
        if (father == null)
            sb = sb.append(", отец не определен");
        else
            sb = sb.append(", отец: ").append(father.getName());
        if (childrens == null)
            sb = sb.append(", детей нет");
        else {
            sb = sb.append(", дети:");
            for (int i = 0; i < childrens.size(); i++) {
                sb = sb.append(" ").append(childrens.get(i).getName());
            }
        }

        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        LocalDate currenDate = LocalDate.now();
        if (getDeathDate() == null)
            return Period.between(birthDate, currenDate).getYears();
        else
            return Period.between(birthDate, deathDate).getYears();
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildrens() {
        return childrens;
    }

    public void addChild
    (Person person) {
        if (this.childrens == null)
            this.childrens = new ArrayList<>();
        this.childrens.add(person);
    }

}