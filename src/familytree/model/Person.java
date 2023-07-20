package familytree.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Person implements Serializable{
    private String name;
    private String surname;
    private String dateOfBirth;
    private String dateOfDeath;
    private String gender;
    private String status;
    private Person partner;
    private List<Person> parents;
    private List<Person> partners;
    private List<Person> children;


    public Person(String name, String surname, String dateOfBirth
            , String dateOfDeath, String gender, String status
            ) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.status=status;
        this.parents = new ArrayList<>();
        this.partners = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, String surname, String dateOfBirth, String gender) {
        this(name,surname,dateOfBirth,null,gender,null);
        this.parents=new ArrayList<>();
        this.partners=new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //-------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getPartners() {
        return partners;
    }

    public void setPartners(List<Person> partners) {
        this.partners = partners;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addParent(Person parent){

        parents.add(parent);
    }

    public void removeParent(Person parent){
        parents.remove(parent);
    }

    public void addPartner(Person partner){
        partners.add(partner);
    }

    public void removePartner(Person partner){
        partners.remove(partner);
    }
    public void addChild(Person child){
        children.add(child);
    }
    public void removeChild(Person child){
        children.remove(child);
    }
    public void addStatus(Person status){
        children.add(status);
    }
    public void removeStatus(Person status){
        children.remove(status);
    }


    public boolean isAlive(){
        return dateOfDeath==null||dateOfDeath.isEmpty();
    }

    public void printInfo() {
        System.out.println("Человек: " + surname + " " + name + " ");
        //System.out.println("Фамилия: " + surname + " ");
        System.out.println("Дата рождения: " + dateOfBirth + " ");
        System.out.println("Дата смерти: " + (dateOfDeath != null ? dateOfDeath : "Живой" + " "));
        System.out.println("Пол: " + gender + " ");
        System.out.println("Родители: " + parentsToString());
        //System.out.println("Родственники: " + partnersToString());
        System.out.println("Дети: " + childrenToString());
        System.out.println("----------------------------------------");
    }

    private String parentsToString() {
        if (parents.isEmpty()) {
            return "Неизвестны";
        }
        StringBuilder sb = new StringBuilder();
        for (Person parent : parents) {
            sb.append(parent.getName()).append(" ").append(parent.getSurname()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
    private String partnersToString() {
        if (partners.isEmpty()) {
            return "Нет родственников";
        }
        StringBuilder sb = new StringBuilder();
        for (Person partner : partners) {
            sb.append(partner.getName()).append(" ").append(partner.getSurname()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
    private String childrenToString() {
        if (children.isEmpty()) {
            return "Нет";
        }
        StringBuilder sb = new StringBuilder();
        for (Person child : children) {
            sb.append(child.getName()).append(" ").append(child.getSurname()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
    //==================================================

    @Override
    public String toString() {
        String par = parentsToString();
        String chil = childrenToString();
        return "==" +
                " " + surname +
                "  " + name + "\n"+
                "   Дата рождения =" + " " + dateOfBirth +"."+
                //", Дата смерти =" +" "+ dateOfDeath  +
                " Пол =" + gender +
                " Родители =" + par +"."+
                " Дети = " + chil+"."+
                " ";
    }


}
