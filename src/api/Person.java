package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable
{
    private String Name;
    private String MiddleName;
    private String Surname;
    private Gender gender;
    private Integer YearOfBirth;
    private Integer YearOfDeath;
    private Person father;
    private Person mother;
    private List<Person> spouse = new ArrayList<>();
    private List<Person> children = new ArrayList<>();

    public Person(String name,
                  String middleName,
                  String surname,
                  Gender gender,
                  Integer yearOfBirth,
                  Integer yearOfDeath)
    {
        Name = name;
        MiddleName = middleName;
        Surname = surname;
        this.gender = gender;
        this.YearOfBirth = yearOfBirth;
        this.YearOfDeath = yearOfDeath;
    }

    public String spouseToString(List<Person> spouse)
    {
        String result = "";
        if (spouse.isEmpty())
        {
            result = null;
        }
        else
        {
            for (int i = 0; i < spouse.size(); i++)
            {
                result += spouse.get(i).Name + " " + spouse.get(i).MiddleName + ";";
            }
        }
        return result;
    }

    public String childrenToString(List<Person> child)
    {
        String result = "";
        if (child.isEmpty())
        {
            result = null;
        }
        else
        {
            for (int i = 0; i < child.size(); i++)
            {
                result += child.get(i).Name + " " + child.get(i).MiddleName + ";";
            }
        }
        return result;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.YearOfBirth = yearOfBirth;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.YearOfDeath = yearOfDeath;
    }

    public String getName() {
        return Name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getNameAndMiddleName()
    {
        return Name + " " + MiddleName;
    }

    public String getSurname() {
        return Surname;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getYearOfBirth() {
        return YearOfBirth;
    }

    public Integer getYearOfDeath() {
        return YearOfDeath;
    }

    @Override
    public String toString() {
        return "api.Person{" +
                "Name='" + Name + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", gender=" + gender +
                ", YearOfBirth=" + YearOfBirth +
                ", YearOfDeath=" + YearOfDeath +
                ", father=" + father +
                ", mother=" + mother +
                ", spouse=" + spouseToString(spouse) +
                ", children=" + childrenToString(children) +
                '}';
    }

    public String printAll()
    {
        String result = "";
        result += "Персона:\n";
        result += this.printInfo();
        result += "\n";

        return result;
    }
    public String printInfo()
    {
        String result = "";
        result += "\t" + Name + " " + MiddleName + " " + Surname + "\n";
        result += "\t" + "Годы жизни    \t\t" + YearOfBirth + " - " + YearOfDeath + "\n";
        return result;
    }

    public void setFather(Person father) {
        this.father = father;
        //father.addChild(this);
        father.children.add(this);
    }

    public Person getFather() {
        return father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        return mother;
    }

    public void addSpouse(Person person)
    {
        this.spouse.add(person);
        person.spouse.add(this);
    }
    public List<Person> getSpouse()
    {
        return this.spouse;
    }

    public void addChild(Person child)
    {
        this.children.add(child);
        child.setFather(this);
    }

    public List<Person> getChildren()
    {
        return children;
    }
}

