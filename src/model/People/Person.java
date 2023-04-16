package model.People;

import model.Tree.TreeInterface;

import java.io.Serializable;
import java.util.*;


public class Person implements
        Serializable, Comparable<Person>, TreeInterface {
    static int generatorId = 1;
    private int id;
    public String firstName;
    public String lastName;
    public String birthDate;
    public String deathDate;
    public Gender gender;
    public Person mother;
    public Person father;
    public List<Person> descendants;


    /**
     * @param firstName   Имя
     * @param lastName    Фамилия
     * @param birthDate   Дата рождения
     * @param deathDate   Дата смерти
     * @param gender      Пол
     */

    public Person(String firstName, String lastName, String birthDate, String deathDate,
                  Gender gender, Person mother, Person father){
        this.id = generatorId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        descendants = new ArrayList<>();
    }

    public Person(String firstName, String lastName, String birthDate, String deathDate, Gender gender) {
        this.id = generatorId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = null;
        this.father = null;
        descendants = new ArrayList<>();
    }

    public Person(int id, String firstName, String lastName, String birthDate, String deathDate,
                  Gender gender, Person mother, Person father) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        descendants = new ArrayList<>();
    }

    public Person(int id, String firstName, String lastName, String birthDate, String deathDate,
                  Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = null;
        this.father = null;
        descendants = new ArrayList<>();
    }

    //    @Override
    public boolean addDescendants(Person descendant){
        if (!descendants.contains(descendant)){
            descendants.add(descendant);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPerson(Object person) {
        return false;
    }

    @Override
    public List<String> searchPerson() {
        return null;
    }

    @Override
    public List<String> searchPersonDescendance() {
        return null;
    }

    @Override
    public String getTreeInfo() {
        return null;
    }

    @Override
    public List getFamilyTree() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean addDescendants() {
        return false;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Gender getGender(){
        return gender;
    }

//    @Override
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("First name: ");
        sb.append(firstName);
        sb.append(", ");
        sb.append("last name: ");
        sb.append(lastName);
        sb.append("\n");
        sb.append("birth date: ");
        sb.append(birthDate);
        sb.append(", ");
        sb.append("death date: ");
        sb.append(deathDate);
        sb.append("\n");
        sb.append(getFatherInfo());
        sb.append("\n");
        sb.append(getMotherInfo());
        sb.append("\n");
        sb.append(getDescendantInfo());
        sb.append("\n");
        sb.append(getId());
        sb.append(".");
        sb.append("\n");
        sb.append("\n");
        return sb.toString();
    }

    public String getMotherInfo(){
        String mom = "Mother: ";
        if (mother != null){
            mom += mother.getFirstName();
            mom += " ";
            mom += mother.getLastName();
        }else {
            mom += "uncnown!";
        }
        return mom;
    }

    public String getFatherInfo(){
        String dad = "Father: ";
        if (mother != null){
            dad += father.getFirstName();
            dad += " ";
            dad += father.getLastName();
        }else {
            dad += "uncnown!";
        }
        return dad;
    }

    public List<Person> getDescendants() {
        return descendants;
    }

    public List<String> getDescendantInfo(){
        StringBuilder chld = new StringBuilder();
        chld.append("Descendants: ");
        if (descendants.size() != 0){
            chld.append(descendants.get(0).getFirstName());
            chld.append(" ");
            chld.append(descendants.get(0).getLastName());
            for (int i = 1; i < descendants.size(); i++) {
                chld.append(", ");
                chld.append(descendants.get(i).getFirstName());
                chld.append(" ");
                chld.append(descendants.get(i).getLastName());
            }
        }else {
            chld.append("no descendants!");
        }
        return Collections.singletonList(chld.toString());
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return Objects.equals(person.getId(), getId());
    }

    @Override
    public String toString() {
            return "Firstname: " + firstName +
                    "\nLastname: " + lastName +
                    "\nbirth date -'" + birthDate + '\'' +
                    "\ndeath date -'" + deathDate + '\'' +
                    "\nID - " + id;

    }
    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.firstName);
    }
}
