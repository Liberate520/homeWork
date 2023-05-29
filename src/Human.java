import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private Gender gender;
    private String father;
    private String mother;
    private String sister;
    private String brother;
    private String grandFather;
    private String grandMother;

    public Human(String name, String surname, LocalDate birthdate, LocalDate deathDate, Gender gender, String father, String mother, String sister, String brother, String grandFather, String grandMother) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.sister = sister;
        this.brother = brother;
        this.grandFather = grandFather;
        this.grandMother = grandMother;
    }


    public Object getAge(LocalDate birthdate, LocalDate deathDate){
       int age = Period.between(birthdate, LocalDate.now()).getYears();
       if(deathDate == null){
           return " " + age + " лет";
       } else if (birthdate == null && deathDate == null) {
           return "Такого персонажа ещее не существует";
       } else {
           int yearsBeforeDeath = Period.between(birthdate,deathDate).getYears();
           return  " умер в возрасте " + yearsBeforeDeath + " лет";
       }
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

    public String getFather() {
        return "Имя отца: " + father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return "Имя матери: " + mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSister() {
        return "Имя сестры: " + sister;
    }

    public void setSister(String sister) {
        this.sister = sister;
    }

    public String getBrother() {
        return "Имя брата: " + brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getGrandFather() {
        return "Имя деда: " + grandFather;
    }

    public void setGrandFather(String grandFather) {
        this.grandFather = grandFather;
    }

    public String getGrandMother() {
        return "Имя бабушки: " + grandMother;
    }

    public void setGrandMother(String grandMother) {
        this.grandMother = grandMother;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", deathDate=" + deathDate +
                ", gender=" + gender +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", sister='" + sister + '\'' +
                ", brother='" + brother + '\'' +
                ", grandFather='" + grandFather + '\'' +
                ", grandMother='" + grandMother + '\'' +
                '}';
    }
}
