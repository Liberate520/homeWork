import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Human {
    private int index;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String deathDate;
    private int fatherIndex;
    private int motherIndex;
    private int spouseIndex;

    public Human(int index, String firstName, String lastName, String birthDate,
                 String deathDate, int fatherIndex, int motherIndex, int spouseIndex){
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.fatherIndex = fatherIndex;
        this.motherIndex = motherIndex;
        this.spouseIndex = spouseIndex;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public int getFatherIndex() {
        return fatherIndex;
    }

    public void setFatherIndex(int fatherIndex) {
        this.fatherIndex = fatherIndex;
    }

    public int getMotherIndex() {
        return motherIndex;
    }

    public void setMotherIndex(int motherIndex) {
        this.motherIndex = motherIndex;
    }

    public int getSpouseIndex() {
        return spouseIndex;
    }

    public void setSpouseIndex(int spouseIndex) {
        this.spouseIndex = spouseIndex;
    }
    @Override
    public String toString() {
        return "Human{" +
                "index=" + index +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", deathDate='" + deathDate + '\'' +
                ", fatherIndex=" + fatherIndex +
                ", motherIndex=" + motherIndex +
                ", spouseIndex=" + spouseIndex +
                '}';
    }
    public Human findSpouse(Human person, ArrayList<Human> people) {
        /**
         * Поиск супруга.
         */
        for (Human otherPerson : people) {
            if (otherPerson.getSpouseIndex() == person.getIndex()) {
                return otherPerson;
            }
        }
        return null;
    }

    public ArrayList<Human> findKids(Human person, ArrayList<Human> people) {
        /**
         * Поиск детей.
         */
        ArrayList<Human> kids = new ArrayList<>();
        for (Human otherPerson : people) {
            if (otherPerson.getFatherIndex() == person.getIndex()
                    || otherPerson.getMotherIndex() == person.getIndex()) {
                kids.add(otherPerson);
            }
            return kids;
        }
        return null;
    }
}

