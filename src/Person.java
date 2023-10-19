import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {
    private final String name;
    private final String surname;
    private final LocalDate burnData;
    private LocalDate deadData;
    private Person mother;
    private Person father;
    private List<MaritalStatus> maritalStatus = new ArrayList<>();
    private List<Person> children = new ArrayList<>();


    public Person(String name, String surname, LocalDate burnData, Person mother,Person father) {
        this.name = name;
        this.surname = surname;
        this.burnData = burnData;
        this.mother = mother;
        this.father = father;
    }
    public Person(String name, String surname, LocalDate burnData) {
        this(name, surname, burnData, null, null);
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public LocalDate getBurnData() { return burnData; }
    public  LocalDate getDeadData() { return deadData; }
    public Person getMother() { return mother;}
    public Person getFather() { return father;}

    // Метод для добавления ребенка
    public void addChild(Person child) { children.add(child); }
    public void addMother(Person mother) { this.mother = mother; }
    public void addFather(Person father) { this.father = father; }
    public void setDead(LocalDate deadData) { this.deadData = deadData; }

    public void setMarriage(Person spouse, LocalDate marriageDate ){
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
}