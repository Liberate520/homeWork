import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Human {
    private Integer humanID;
    private String humanName;
    private String humanSurname;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private Integer motherID;
    private Integer fatherID;
    private Integer partnerID;

    public Human(Integer humanID, String humanName, String humanSurname, Date dateOfBirth, Date dateOfDeath, Integer motherID, Integer fatherID, Integer partnerID) {
        this.humanID = humanID;
        this.humanName = humanName;
        this.humanSurname = humanSurname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.motherID = motherID;
        this.fatherID = fatherID;
        this.partnerID = partnerID;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [" + humanID + "] " + humanName + " " + humanSurname);
        result.append("\n\tдата рождения: ").append(df.format(dateOfBirth));
        if (dateOfDeath != null) result.append("\n\tдата смерти: ").append(df.format(dateOfDeath));

        return result.toString();
    }

    public String inFamily (FamilyTree family) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder result = new StringBuilder(" [").append(humanID).append("] ").append(humanName).append(" ").append(humanSurname);
        result.append("\n\tдата рождения: ").append(df.format(dateOfBirth));
        if (dateOfDeath != null) result.append("\n\tдата смерти: ").append(df.format(dateOfDeath));
        if (motherID != null) result.append("\n\tМать: ").append(family.getNameByID(motherID));
        if (fatherID != null) result.append("\n\tОтец: ").append(family.getNameByID(fatherID));
        if (partnerID != null) result.append("\n\tСемейная пара: ").append(family.getNameByID(partnerID));

        ArrayList<String> childrens;
        childrens = family.getChildrens(humanID);

        if (childrens.size() > 0) {
            result.append("\n\n\tДети: ");
            for (String children : childrens) {
                result.append("\n\t\t").append(children);
            }
        }

        ArrayList<String> brothersAndSisters;
        brothersAndSisters = family.getBrothersAndSisters(motherID, fatherID, humanID);
        if (brothersAndSisters.size() > 0) {
            result.append("\n\n\tБратья и сестры: ");
            for (String bs : brothersAndSisters) {
                result.append("\n\t\t").append(bs);
            }
        }

        return result.toString();
    }

    public String getHumanName() {
        return humanName + " " + humanSurname;
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
}
