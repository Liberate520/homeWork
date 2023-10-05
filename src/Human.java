import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String fullName;
    private Gender gender;
    private Relationship relationship;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> child;

    public Human(String fullName, Gender gender, Relationship relationship,
                 LocalDate birthDate, LocalDate deathDate) {
        id = -1;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.relationship = relationship;
        child = new ArrayList<>();
    }

    public List<Human> getChild() {
        return child;
    }
    public void setChild(List<Human> child) {
        this.child = child;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Relationship getRelationship() {
        return relationship;
    }
    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getData(){
        StringBuilder dataCard = new StringBuilder();
        dataCard.append("id: ");
        dataCard.append(id);
        dataCard.append("Full Name: ");
        dataCard.append(fullName);
        dataCard.append("Gender: ");
        dataCard.append(getGender());

        return dataCard.toString();
    }

}
