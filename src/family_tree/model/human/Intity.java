package family_tree.model.human;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.tree.FamilyTreeItem;

public abstract class Intity implements Serializable, FamilyTreeItem<Human, Kinship>{
    protected int id;
    protected String name;
    protected Gender gender;
    protected LocalDate dateOfBirth;
    protected LocalDate dateOfDeath;


    public Intity(int id, String name, Gender gender, LocalDate dateOfBirth,
            LocalDate dateOfDeath) {
        this.id = id;
        this.name = name;
        this.gender = gender;        
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public int getId () {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOdBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean setDateOfDeath(LocalDate date) {
        if (date != null && date.isAfter(dateOfBirth)) {
            this.dateOfDeath = date;
            return true;
        }
        return false;        
    }    
}
