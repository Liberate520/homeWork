import java.util.ArrayList;
import java.util.List;

public class Person {
    private static int generatorID = 1;
    private final int id;

    public String firstName;
    public String lastName;
    public String birthDate;
    public String deathDate;
    public Gender gender;
    public int idMather;
    public int idFather;

    /**
     * @param id id
     * @param firstName   Имя
     * @param lastName    Фамилия
     * @param birthDate   Дата рождения
     * @param deathDate   Дата смерти
     * @param gender      Пол
     * @param idMather    id Матери
     * @param idFather    id Отца
     */

    public Person(String firstName, String lastName, String birthDate, String deathDate, Gender gender, int idMather, int idFather){
        this.id = generatorID++;
//        this.id = new GeneratorID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.idMather = idMather;
        this.idFather = idFather;
    }

    public Person(String firstName, String lastName, String birthDate, String deathDate, Gender gender) {
        this.id = generatorID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public int getIdMather() {
        return idMather;
    }

    public int getIdFather() {
        return idFather;
    }

    @Override
    public String toString() {

            return "Firstname: " + firstName +
                    "\nLastname: " + lastName +
                    "\nbirth date -'" + birthDate + '\'' +
                    "\ndeath date -'" + deathDate + '\'' + //"\n"; //+
                    "\nID - " + id;

    }
}
