package family_tree.backend.person;

import family_tree.backend.ftree.Wedding;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Marriage implements Serializable, Wedding {
    private List<Person> spousesList;
    private String marriedName; 
    private LocalDate marriedDate;
    private LocalDate divorceDate;

    public Marriage(List<Person> spousesList, LocalDate marriedDate, String marriedName, LocalDate divorceDate){
        this.spousesList = spousesList;
        this.marriedName = marriedName;
        this.marriedDate = marriedDate;
        this.divorceDate = divorceDate;
    }

    public Marriage(List<Person> spousesList, LocalDate marriedDate, String marriedName){
        this.spousesList = spousesList;
        this.marriedName = marriedName;
        this.marriedDate = marriedDate;
        this.divorceDate = null;
    }
    public Marriage(List<Person> spousesList, LocalDate marriedDate){
        this.spousesList = spousesList;
        this.marriedDate = marriedDate;
        this.marriedName = null;
        this.divorceDate = null;
    }

    public List<Person> getSpousesList(){
        try {
            return spousesList;
        }
        catch (Exception e){
            return null;
        }
    }

    public String getMarriageDates(){
        StringBuilder sB = new StringBuilder();
        sB.append(marriedDate);
        if (divorceDate != null){
            sB.append(" - ");
            sB.append(divorceDate);
        }

        return sB.toString();
    }

    public String getMarriedName(){
        return marriedName;
    }

}
