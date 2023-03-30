import java.util.Objects;

public class Person {
    private Integer id;
    private String fullName;
    private Integer birthYear;
    
    public Person(Integer id, String fullName, Integer birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Person() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(Integer birthDate) {
        this.birthYear = birthDate;
    }

    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return this.id == person.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthYear);
    }

    @Override
    public String toString() {
        return (fullName == null ? "<Неизвестно>" : fullName) + " (" + (birthYear == null ? "<Неизвестно>" : birthYear)
                + ")";
    }

}
