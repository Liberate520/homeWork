import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
//    private List<Person>parents;
//    private List<Person> children;
    private List<Relationship> relationships;

    public Person(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate /*, Person father, Person mother*/) {
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
    //TODO make collision-like AND GETALLINFO METHOD
    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
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

    public void addRelationship(Person child, RelationshipType type) {
    }

    @Override
    public String toString() {
        return "Person{" +
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
        info.append("Gender: ").append(gender).append("\n");
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
                Person person1 = relationship.getPerson1();
                Person person2 = relationship.getPerson2();
                RelationshipType type = relationship.getType();

                String relationshipInfo = person1.getFullName() + " (" + person1.getGender() + ") - " +
                        person2.getFullName() + " (" + person2.getGender() + ") : " +
                        type;

                info.append(relationshipInfo).append("\n");
            }
        } else {
            info.append("No Relationships\n");
        }

        return info.toString();
    }


}