package person;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Human implements Serializable, Person {
    private Integer ID;
    private String personName;
    private String personSurname;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Integer motherID;
    private Integer fatherID;
    private Integer partnerID;

    public Human(Integer ID, String personName, String personSurname, Date dateOfBirth,
                 Date dateOfDeath, Integer motherID, Integer fatherID, Integer partnerID) {
        this.ID = ID;
        this.personName = personName;
        this.personSurname = personSurname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.motherID = motherID;
        this.fatherID = fatherID;
        this.partnerID = partnerID;
    }

    public Human() {
        this(-1, "<empty>", "", null, null, null, null, null);
    }

    public Human(Integer id) {
        this(id, "", "", null, null, null, null, null);
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [" + ID + "] " + personName + " " + personSurname);
        if (dateOfBirth != null) result.append("\n\tдата рождения: ").append(df.format(dateOfBirth));
        if (dateOfDeath != null) result.append("\n\tдата смерти: ").append(df.format(dateOfDeath));

        return result.toString();
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setMotherID(Integer motherID) {
        this.motherID = motherID;
    }

    public void setFatherID(Integer fatherID) {
        this.fatherID = fatherID;
    }

    public void setPartnerID(Integer partnerID) {
        this.partnerID = partnerID;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public String getHumanFullName() {
        return personName + " " + personSurname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public Integer getPartnerID() {
        return partnerID;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getMotherID() {
        return motherID;
    }

    public Integer getFatherID() {
        return fatherID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return ID.equals(human.ID) && dateOfBirth.equals(human.dateOfBirth) && Objects.equals(motherID, human.motherID) && Objects.equals(fatherID, human.fatherID) && Objects.equals(partnerID, human.partnerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, dateOfBirth, motherID, fatherID, partnerID);
    }
}
