package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

class Person implements Serializable {
    private final String name;
    private final String surname;
    private Gender gender;
    private final LocalDate burnData;
    private LocalDate deadData;
    private Person mother;
    private Person father;
    private List<MaritalStatus> maritalStatus = new ArrayList<>();
    private List<Person> children = new ArrayList<>();


    public Person(String name, String surname, Gender gender, LocalDate burnData, Person mother,Person father) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.burnData = burnData;
        this.mother = mother;
        this.father = father;
    }
    public Person(String name, String surname, Gender gender, LocalDate burnData) {
        this(name, surname, gender, burnData, null, null);
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Gender getGender() { return gender; }
    public LocalDate getBurnData() { return burnData; }
    public  LocalDate getDeadData() { return deadData; }
    public Person getMother() { return mother;}
    public Person getFather() { return father;}
    public MaritalStatus getMaritalStatus() {
        return maritalStatus.getLast();
    }

    // Метод для добавления ребенка
    public void addChild(Person child) { children.add(child); }
    public void addMother(Person mother) { this.mother = mother; }
    public void addFather(Person father) { this.father = father; }
    public void setDead(LocalDate deadData) { this.deadData = deadData; }

    public void setMarriage(Person spouse, LocalDate marriageDate ) {
        maritalStatus.add(new MaritalStatus(spouse, marriageDate));
    }
    public void setDivorce(Person spouse, LocalDate divorceDate){
        for (MaritalStatus ms : maritalStatus){
            if (ms.getSpouse().equals(spouse) && ms.getDivorceDate() == null){
                ms.setDivorceDate(divorceDate);
            }
        }
    }

    public List<Person> getChildren() { return children; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(burnData, person.burnData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, burnData);
    }

    @Override
    public String toString() {
        // Поиск брака
        String status = "не в браке";
        if (!maritalStatus.isEmpty()){
            for (MaritalStatus ps : maritalStatus) {
                if (ps.getDivorceDate() == null){
                    status = "в браке с " + ps.getSpouse().getName();
                }
            }
        }
        // Поиск детей
        StringBuilder childrenStrList = new StringBuilder("детей нет");
        if (!children.isEmpty()){
            for (Person ch : children) {
                childrenStrList.append(ch.getName()).append(", ");
            }
        }

        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", burnData=" + burnData +
                ", deadData=" + deadData +
                ", mother=" + ((mother == null)? "нет" : mother.getName()) +
                ", father=" + ((father == null)?  "нет" : father.getName()) +
                ", maritalStatus=" + status +
                ", children=" + childrenStrList +
                '}';
    }

    enum Gender {man, woman};
}