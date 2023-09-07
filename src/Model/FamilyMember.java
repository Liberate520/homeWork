package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyMember<T> implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Relationship> relationships;

    private T specificData;  // Добавляем специфичные данные


    public FamilyMember(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, T specificData) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.specificData = specificData;
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

    public int getId() {
        return id;
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

    public void addRelationship(RelationshipType type, FamilyMember relatedMember) {
        Relationship relationship = new Relationship(this, relatedMember, type);
        relatedMember.relationships.add(relationship);

        if (type == RelationshipType.ANCESTOR || type == RelationshipType.FATHER || type == RelationshipType.MOTHER) {
            if (!this.relationships.contains(relationship)) {
                this.relationships.add(relationship);
            }
            if (!relatedMember.relationships.contains(relationship)) {
                relatedMember.relationships.add(relationship);
            }
        } else if (type == RelationshipType.CHILD) {
            if (!this.relationships.contains(relationship)) {
                this.relationships.add(relationship);
            }
            if (!relatedMember.relationships.contains(relationship)) {
                relatedMember.relationships.add(relationship);
            }
        } else if (type == RelationshipType.SPOUSE) {
            if (!this.relationships.contains(relationship)) {
                this.relationships.add(relationship);
            }
            if (!relatedMember.relationships.contains(relationship)) {
                relatedMember.relationships.add(relationship);
            }
        } else if (type == RelationshipType.SIBLING) {
            if (!this.relationships.contains(relationship)) {
                this.relationships.add(relationship);
            }
            if (!relatedMember.relationships.contains(relationship)) {
                relatedMember.relationships.add(relationship);
            }
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
