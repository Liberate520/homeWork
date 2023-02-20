import java.io.Serializable;

public class SavingFT implements Serializable{
    private FamilyTree people;

    public SavingFT(FamilyTree people){
        this.people = people;
    }

    public FamilyTree getPeople() {
        return people;
    }

    public void setPeople(FamilyTree people) {
        this.people = people;
    }

}
