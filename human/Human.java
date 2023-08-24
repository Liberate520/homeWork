package human;
import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String fullName;
    private human.Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;


    public Human(String fullName, Gender gender, LocalDate birthDate,LocalDate deathDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;


    }
    public Human(String fullName, Gender gender, LocalDate birthDate) {
        this(fullName, gender, birthDate, null);
    }


    public String getFullName() {
        return fullName;

    }

    public human.Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }



    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" имя: ");
        sb.append(getFullName());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(getBirthDate());
        sb.append(" если он(а) является ");
        return sb.toString();
    }



    public String getHuman() {
        StringBuilder builder = new StringBuilder();
        builder.append(getFullName());
        builder.append(getAge());
        return builder.toString();
    }
}

