package FamilyTree.model.Person;

import java.io.Serializable;
import java.time.LocalDate;

public class MaritalStatus implements Serializable {
    private Person spouse = null;
    private LocalDate marriageDate = null;
    private LocalDate divorceDate = null;

    public MaritalStatus(Person spouse, LocalDate marriage){
        this.spouse = spouse;
        this.marriageDate = marriage;
    }
    public MaritalStatus(Person spouse){
        this(spouse, null);
    }
    public MaritalStatus(){}

    public Person getSpouse() { return spouse; }
    public LocalDate getMarriageDate() { return marriageDate; }
    public LocalDate getDivorceDate() { return divorceDate; }

    public void setMarriageDate(LocalDate marriageDate) { this.marriageDate = marriageDate; }
    public void setDivorceDate(LocalDate divorceDate) { this.divorceDate = divorceDate; }
}