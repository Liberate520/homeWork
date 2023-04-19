import java.util.*;
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
            Iterator iterator = humanList.iterator();
            while (iterator.hasNext()) {
                Human var = iterator.next();
                if (var.getGender().equals(Gender.Female)) {
                    return var;
                }
            }
            return null;
    }

    @Override
    public String toString() {
        return "Фамилия" + " " + lastName + " " + "Имя" + " " + firstName + " " + "Пол" + " " + gender;
    }
}
