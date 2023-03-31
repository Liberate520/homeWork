import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private String fullName;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Gender gender;

    public Person(String fullName, Calendar dateOfBirth, Calendar dateOfDeath, Gender gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dateOfDeath = dateOfDeath;
    }
    public Person(String fullName, Calendar dateOfBirth, Gender gender) {
        this(fullName, dateOfBirth, null, gender);
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

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Full name: " + getFullName();
    }
}