import java.util.*;

public class Person {
    private String fullName;
    private Calendar dateOfBirth;
    private Gender gender;
    private Map<Person, Relation> relation;

    public Person(String fullName, Calendar dateOfBirth, Gender gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.relation = new HashMap<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        Calendar currentDate = new GregorianCalendar();
        return currentDate.get(Calendar.YEAR) - this.getDateOfBirth().get(Calendar.YEAR);
    }

    public Gender getGender() {
        return gender;
    }

    public Map<Person, Relation> getRelation() {
        return relation;
    }

    public void setRelation(Map<Person, Relation> relation) {
        this.relation = relation;
    }

    public void addRelation(Person person, Relation relation) {
        this.relation.put(person, relation);
    }

    @Override
    public String toString() {
        return "Full name: " + getFullName();
    }
}
