import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human {
    private static int globalId;
    private int id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private Gender gender;

    public Human(String name, String surname, LocalDate birthdate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    /**
     *
     * TODO Не могу понять как реализовать возвращение возраста с учетом даты смерти,
     */
//    public String getAge() {
//        LocalDate now = LocalDate.now();
//        Period period = Period.between(birthdate, deathDate);
//        int years = period.getYears();
//        if(deathDate != null){
//            return "Умер в возрасте " + years;
//        }
//        else{
//        return ((Integer) Period.between(birthdate, now).getYears());
//        }
//    }

    public  int getAge(){
        LocalDate now = LocalDate.now();
        return  Period.between(birthdate,now).getYears();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", deathDate=" + deathDate +
                ", gender=" + gender +
                '}';
    }
}
