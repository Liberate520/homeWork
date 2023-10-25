package genealogy_tree.person;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable{
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private String firstName;
    private String lastName;
    private String surName;
    private Gender gender;
    private Calendar birthDate;
    private Calendar deathDate;
    private Parents parents;
    private List<Person> children;

    public Person(String firstName, String surName, String lastName, Gender gender, Calendar birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parents = new Parents();
        this.children = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

     public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }     

    public Calendar getBirthDate() {
        return birthDate;
    }

    public Calendar getDeathDate() {
        return deathDate;
    }
    
    public void setDeathDate(Calendar deathDate) {
        this.deathDate = deathDate;
    }    

    public String getParents() {
        return parents.toString();
    }

    public void setParent(Person parent){
        parents.setParent(parent);
        if (!parent.children.contains(this)) {
            parent.addChild(this);
        }
    }  

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
        }
        child.setParent(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName + ' ');
        sb.append(surName + ' ');
        sb.append(lastName + ' ');
        sb.append('(' + Person.dateFormat.format(getBirthDate().getTime()));
        if (getDeathDate() != null){
            sb.append(" - " + Person.dateFormat.format(getDeathDate().getTime()));
        }
        sb.append(')');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
               Objects.equals(lastName, person.lastName) &&
               Objects.equals(surName, person.surName) &&
               Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, surName, birthDate);
    }
}