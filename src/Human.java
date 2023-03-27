import java.util.*;

public class Human {
    private String name;
    private Gender gender;
    private List<FamilyRelationships> relationshipsList;
    private Calendar birthDay;

    private Human(String name, Gender gender, List<FamilyRelationships> relationshipsList, Calendar birthDay) {
        this.name = name;
        this.gender = gender;
        this.relationshipsList = new ArrayList<>();
        this.birthDay = birthDay;
    }

    public Human(String name, Gender gender, Calendar birthDay) {
        this(name, gender, new ArrayList<>(), birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }
    public int getAge() {
        Calendar currentDate = new GregorianCalendar();
        return currentDate.get(Calendar.YEAR) - this.getBirthDay().get(Calendar.YEAR);
    }

    public List<FamilyRelationships> getRelationshipsList() {
        return relationshipsList;
    }

    public void addRelationship(FamilyRelationships relationship){
        relationshipsList.add(relationship);
    }

    public void addRelationship(Human human, Relationships relationships){
        addRelationship(new FamilyRelationships(human, relationships));
    }

    public void showRelationships(Relationships relationships){
        for (FamilyRelationships relationship : relationshipsList) {
            if(relationship.getRelationships() == relationships){
                System.out.println(relationship.getHuman());
            }
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: "+ getAge() + ", Пол: " + gender + ", Родственники: \n" + relationshipsList +  "\n";
    }
}
