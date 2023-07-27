import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human mother, Human father) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = null;
        this.father = null;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        int age;
        if (this.deathDate == null) {
            age = Period.between(this.birthDate, LocalDate.now()).getYears();
        } else {
            age = Period.between(this.birthDate, this.deathDate).getYears();
        }
        return age;
    }

    public String getGender() {
        return gender.toString();
    }

    public Human getMother() {
        if(mother == null) {
        }
        return mother;
    }

    public Human getFather() {
        if(father == null) {
        }
        return father;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("age: ");
        stringBuilder.append(getAge());
        stringBuilder.append("\n");
        stringBuilder.append("gender: ");
        stringBuilder.append(gender);
        stringBuilder.append("\n");
        if (this.mother != null) {
            stringBuilder.append("mother: ");
            stringBuilder.append(getMother().getName());
            stringBuilder.append("\n");
        }
        if(father != null) {
            stringBuilder.append("father: ");
            stringBuilder.append(getFather().getName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
