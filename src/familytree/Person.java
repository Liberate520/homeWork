package familytree;


import java.util.ArrayList;
import java.util.List;
public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String dateOfDeath;
    private String gender;
    List<Person> parents;
    List<Person> partners;
    List<Person> children;


    //---Создаем коструктор---------------
    public Person(String name, String surname, String dateOfBirth
            , String dateOfDeath, String gender
            ) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;  //---может быть пустым/null, если человек жив
        this.gender = gender;
        this.parents = new ArrayList<>(); //----может быть пустым/null, если родители неизвестны
        this.partners = new ArrayList<>();//----список людей, с которыми он/она состояла/состоит в браке
        this.children = new ArrayList<>();//---список детей
    }

    //---Геттеры и Сеттеры----------------

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

    //----Методы для добавления/удаления

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
    //--Проверка жив человек или нет
    public boolean isAlive(){
        return dateOfDeath==null||dateOfDeath.isEmpty();
    }
    //---Методы для получения списка предков и потомков
    public List<Person> getAncestors(){
        List<Person> ancestors = new ArrayList<>();
        for(Person parent : partners){
            ancestors.add(parent);
            ancestors.addAll(parent.getAncestors());
        }
        return ancestors;
    }
    public List<Person> getDescendants(){
        List<Person> descendants = new ArrayList<>();
        for(Person child : children){
            children.add(child);
            children.addAll(child.getDescendants());
        }
        return descendants;
    }
    //=== Методы вывода информации о людях
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Death: " + (dateOfDeath != null ? dateOfDeath : "Alive"));
        System.out.println("Gender: " + gender);
        System.out.println("Parents: " + parentsToString());
        System.out.println("Partners: " + partnersToString());
        System.out.println("Children: " + childrenToString());
    }

    private String parentsToString() {
        if (parents.isEmpty()) {
            return "Unknown";
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
            return "None";
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
            return "None";
        }
        StringBuilder sb = new StringBuilder();
        for (Person child : children) {
            sb.append(child.getName()).append(" ").append(child.getSurname()).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove the last comma and space
        return sb.toString();
    }

}
