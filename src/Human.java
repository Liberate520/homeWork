import java.util.UUID;

public class Human {
    private String uid;
    private String name;
    private String lastName;
    private String secondName;
    private Gender gender; 
    private Human parentFather;
    private Human parentMother;
    private int generation;

    public Human(String name, Gender gender) {
        this.uid = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.lastName = this.gender == Gender.MAN ? "Иванов" : "Иванова";
        this.secondName = this.gender == Gender.MAN ? "Иванович" : "Ивановна";
    }


    @Override
    public String toString() {
        return this.getFIOtoString() + "\n"
            + "пол: " + (gender == Gender.MAN ? "мужской" : "женский") + "\n"
            + "отец: " + (this.getParentFather() != null ? this.getParentFather().getFIOtoString() : "отсутствует") + "\n"
            + "мать: " + (this.getParentMother() != null ? this.getParentMother().getFIOtoString() : "отсутствует");
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public void setParentFather(Human parentFather) {
        this.parentFather = parentFather;
    }


    public void setParentMother(Human parentMother) {
        this.parentMother = parentMother;
    }


    public String getUid() {
        return uid;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getSecondName() {
        return secondName;
    }

    
    public String getFIOtoString() {
        return this.lastName + " " + this.name + " " + this.secondName;
    }


    public Gender getGender() {
        return gender;
    }


    public Human getParentFather() {
        return parentFather;
    }


    public Human getParentMother() {
        return parentMother;
    }


    public int getGeneration() {
        return generation;
    }
}