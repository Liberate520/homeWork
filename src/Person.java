import java.util.Objects;

public class Person {
    private String fullName;
    private Integer birthYear;
    // (TODO) Заменить на Date
    // private Date deathDate;

    public Person(Integer id, String fullName, Integer birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Person() {
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
        return Objects.equals(fullName, person.fullName) && Objects.equals(birthYear, person.birthYear);
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
