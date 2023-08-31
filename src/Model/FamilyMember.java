package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyMember implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
//    private List<Model.FamilyMember>parents;
//    private List<Model.FamilyMember> children;
    private List<Relationship> relationships;

    public FamilyMember(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate /*, Model.FamilyMember father, Model.FamilyMember mother*/) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
//        this.children = new ArrayList<>();
//        this.parents = new ArrayList<>():
//        if (father != null){parents.add(father);}
//        if (mother != null){parents.add(mother);}
        this.relationships = new ArrayList<>();
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return deathDate != null ? deathDate.getYear() - birthDate.getYear() : currentDate.getYear() - birthDate.getYear();
    }

    public int getYearsSinceDeath() {
        if (deathDate != null) {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - deathDate.getYear();
        }
        return 0;
    }

    public boolean isAlive() {
        return deathDate == null;
    }
    //TODO make collision-like AND GET ALL INFO METHOD
    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);

        if (!relationship.getPerson2().relationships.contains(relationship)) {
            // Create symmetric relationship for person2
            Relationship symmetricRelationship = new Relationship(relationship.getPerson2(), this, relationship.getType());
            relationship.getPerson2().relationships.add(symmetricRelationship);
        }
    }


    public List<Relationship> getRelationships() {
        return relationships;
    }

    public String getDeathYear() {
        if (deathDate != null) {
            return String.valueOf(deathDate.getYear());
        } else {
            return "N/A"; // Или любое другое значение, указывающее на отсутствие данных о смерти
        }
    }

    public void addRelationship(FamilyMember child, RelationshipType type) {
    }

    @Override
    public String toString() {
        return "Model.FamilyMember{" +
                "id=" + id +
                ", fullName='" + getFullName() + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + getDeathYear() +
                '}';
    }

    public String getAllInfo() {
        StringBuilder info = new StringBuilder();

        info.append("ID: ").append(id).append("\n");
        info.append("Full Name: ").append(getFullName()).append("\n");
        info.append("Model.Gender: ").append(gender).append("\n");
        info.append("Birth Date: ").append(birthDate).append("\n");
        info.append("Death Date: ").append(getDeathYear()).append("\n");

        if (isAlive()) {
            info.append("Age: ").append(getAge()).append(" years\n");
        } else {
            info.append("Age: ").append(getAge()).append(" years (died ").append(getYearsSinceDeath()).append(" years ago)\n");
        }

        List<Relationship> relationships = getRelationships();
        if (!relationships.isEmpty()) {
            info.append("Relationships:\n");
            for (Relationship relationship : relationships) {
                FamilyMember familyMember1 = relationship.getPerson1();
                FamilyMember familyMember2 = relationship.getPerson2();
                RelationshipType type = relationship.getType();

                String relationshipInfo = String.format(
                        "%s (%s) - %s (%s) : %s",
                        familyMember1.getFullName(), familyMember1.getGender(),
                        familyMember2.getFullName(), familyMember2.getGender(),
                        type
                );

                info.append(relationshipInfo).append("\n");
            }
        } else {
            info.append("No Relationships\n");
        }


        return info.toString();
    }


}