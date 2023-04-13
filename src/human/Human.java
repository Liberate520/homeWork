package human;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Human implements Serializable {
    private Integer humanID;
    private String humanName;
    private String humanSurname;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Integer motherID;
    private Integer fatherID;
    private Integer partnerID;

    public Human(Integer humanID, String humanName, String humanSurname, Date dateOfBirth,
                 Date dateOfDeath, Integer motherID, Integer fatherID, Integer partnerID) {
        this.humanID = humanID;
        this.humanName = humanName;
        this.humanSurname = humanSurname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.motherID = motherID;
        this.fatherID = fatherID;
        this.partnerID = partnerID;
    }

    public Human() {
        this(-1, "<empty>", "", null, null, null, null, null);
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [" + humanID + "] " + humanName + " " + humanSurname);
        if (dateOfBirth != null) result.append("\n\tдата рождения: ").append(df.format(dateOfBirth));
        if (dateOfDeath != null) result.append("\n\tдата смерти: ").append(df.format(dateOfDeath));

        return result.toString();
    }

    public String getHumanName() {
        return humanName;
    }

    public String getHumanSurname() {
        return humanSurname;
    }

    public String getHumanFullName() {
        return humanName + " " + humanSurname;
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

    public Integer getHumanID() {
        return humanID;
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
        return humanID.equals(human.humanID) && dateOfBirth.equals(human.dateOfBirth) && Objects.equals(motherID, human.motherID) && Objects.equals(fatherID, human.fatherID) && Objects.equals(partnerID, human.partnerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humanID, dateOfBirth, motherID, fatherID, partnerID);
    }
}
