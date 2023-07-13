package family_tree;

import family_tree.family_tree.FamilyTreeItem;
import family_tree.human.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Dog implements FamilyTreeItem<Dog> {
    private long id;
    private String firstName, lastName, middleName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Dog mother, father;
    private List<Dog> children;
    private Gender sex;
    private Dog spouse;

    public Dog(String firstName, String lastName, String middleName, LocalDate dateOfBirth,
               LocalDate dateOfDeath, Dog mother, Dog father, List<Dog> children, Gender sex, Dog spouse) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.sex = sex;
        this.spouse = spouse;
    }
    public Dog(String firstName, LocalDate dateOfBirth, Dog mother, Dog father, Gender sex) {
        this(firstName, null, null, dateOfBirth, null, mother, father, null, sex, null);
        this.children = new ArrayList<>();
    }
    public Dog() {
        this.children = new ArrayList<>();
    }
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        if (dateOfDeath == null)
            return getPeriod(dateOfBirth, LocalDate.now());
        else
            return getPeriod(dateOfBirth, dateOfDeath);
    }
    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period age = Period.between(dateOfBirth, dateOfDeath);
        return age.getYears();
    }
    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Dog getMother() {
        return mother;
    }
    @Override
    public Dog getFather() {
        return father;
    }

    @Override
    public Gender getGender() {
        return sex;
    }

    @Override
    public Dog getSpouse() {
        return spouse;
    }

    @Override
    public List<Dog> getChildren() {
        return children;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setSpouse(Dog spouse) {
        this.spouse = spouse;
    }

    @Override
    public void addChildren(Dog child) {
        if ((!child.equals(null)) && (!this.children.contains(child)))
            this.children.add(child);
    }

    @Override
    public void addFather(Dog dog) {
        if (dog.getGender() == Gender.male)
            this.setFather(dog);
    }

    private void setFather(Dog dog) {
        this.father = father;
    }

    @Override
    public void addMother(Dog dog) {
        if (dog.getGender() == Gender.female)
            this.setMother(dog);
    }

    private void setMother(Dog dog) {
        this.mother = mother;
    }

    @Override
    public void setChildren(List<Dog> children) {
        for (Dog child : children) {
            if (!this.children.contains(child))
                this.children.add(child);
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mother=" + mother.firstName +
                ", father=" + father.firstName +
                ", sex=" + sex +
                '}';
    }
}
