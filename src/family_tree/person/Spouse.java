package family_tree.person;

import java.time.LocalDate;
import java.util.List;

public class Spouse extends Person{
    private List<Spouse> spouse;
    private String marriedName;
    private LocalDate marriedDate;
    private LocalDate divorceDate;

    public Spouse(List<Spouse> spouse, String marriedName, LocalDate marriedDate, LocalDate divorceDate){
        super(firstName, lastName, genderBirth, birthDate, null, null);
        this.spouse = spouse;
        this.marriedName = marriedName;
        this.marriedDate = marriedDate;
        this.divorceDate = divorceDate;
    }
    
    public Spouse(List<Spouse> spouse, String marriedName, LocalDate marriedDate){
        this(spouse,marriedName,marriedDate,null);
    }
    
}
