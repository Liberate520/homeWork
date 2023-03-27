import java.util.Objects;

public class Person {
    private String fullName;
    private String birthDate;
    // (TODO) Заменить на Date
    // private Date deathDate;

    public Person(String fullName, String birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(fullName, person.fullName) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthDate);
    }

    @Override
    public String toString() {
        return (fullName == null ? "<Неизвестно>" : fullName) + " (" + (birthDate == null ? "<Неизвестно>" : birthDate)
                + ")";
    }

}
