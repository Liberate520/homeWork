import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private String fullName;
    private Calendar dateOfBirth;
    private Gender gender;

    public Person(String fullName, Calendar dateOfBirth, Gender gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Full name: " + getFullName();
    }
}