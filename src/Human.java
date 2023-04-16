
import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private String  birthday;
    private Gender gender;
    private Human mother;
    private Human father;

    public Human(String firstName, String lastName, String birthday, Gender gender,Human mother,Human father){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }public Human(String firstName, String lastName, String birthday, Gender gender){
        this(firstName, lastName,birthday, gender, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return firstName.equals(human.firstName) &&
                lastName.equals(human.lastName) &&
                birthday.equals(human.birthday) &&
                gender.equals(human.gender) &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, gender);
    }

    @Override
    public String toString() {
        return "[" +
                 firstName +
                 " " + lastName +
                ", " + birthday +
                ", " + gender +
//                ", Мать: " + mother +
//                ", Отец: " + father +
                ']';
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        if (this.father == null && father.gender != Gender.Female) {
            this.father = father;
        }
    }

    public void setMother(Human mother) {
        if (this.mother == null && mother.gender != Gender.Male) {
            this.mother = mother;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }
}
