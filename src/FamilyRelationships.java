import java.util.Calendar;

public class FamilyRelationships {
    Human human;
    Relationships relationships;

    public FamilyRelationships(Human human, Relationships relationships) {
        this.human = human;
        this.relationships = relationships;
    }

    public Human getHuman() {
        return human;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    @Override
    public String toString() {
        return "Имя: " + human.getName() + ", Возраст: "+ human.getAge() + ", Пол: " + human.getGender() + ", Родство: " + relationships + "\n";
    }
}
