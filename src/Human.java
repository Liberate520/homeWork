import java.util.List;
import java.util.Objects;

public class Human {
   private Gender gender;
    private String lastName;
    private String firstName;
    List<Human> humanList;




    public Human(String lastName, String firstName,Gender gender){
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public Gender getGender() {
        return gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addHuman(Human human){
        humanList.add(human);
    }
        public Human findGender(Gender gender, List humanList) {
        for (Human human: humanList) {
            if (human.getGender() == Gender.Female) {
                return human;
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "Фамилия" + " " + lastName + " " + "Имя" + " " + firstName + " " + "Пол" + " " + gender;
    }
}
