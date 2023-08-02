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

    public Marriage(List<Person> spousesList, String marriedName, LocalDate marriedDate, LocalDate divorceDate){
        this.spousesList = spousesList;
        this.marriedName = marriedName;
        this.marriedDate = marriedDate;
        this.divorceDate = divorceDate;
    }

    public Marriage(List<Person> spousesList, String marriedName, LocalDate marriedDate){
        this.spousesList = spousesList;
        this.marriedName = marriedName;
        this.marriedDate = marriedDate;
        this.divorceDate = null;
    }

    public void addSpouse(Person person)
    {
        spousesList.add(person);

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

}
