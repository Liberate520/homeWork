package family_tree.human;

import family_tree.base.Iterable;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Human implements Iterable, Serializable {
    private final String lastName;
    private final String firstName;
    private final Gender gender;
    private final Fondation fondation;
    private final Position position;
    private final SocialPosition socialPosition;
    private final double income;

    private LocalDate birthDate;
    private LocalDate deathDate;
    private final double id;


    public <children> Human(String lastName, String firstName, Gender gender, Position position, SocialPosition socialPosition, Fondation fondation, double income, LocalDate birthDate, LocalDate deathDate, double id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.position = position;
        this.socialPosition = socialPosition;
        this.fondation = fondation;
        this.income = income;
//        this.age = age;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.id = id;
        List<Human> children = new ArrayList<>();
    }

    public Human(String lastName, String firstName, Gender gender, Position position, SocialPosition socialPosition, Fondation fondation, double income, LocalDate birthDate, double id) {
        this(lastName, firstName, gender, position, socialPosition, fondation, income, birthDate, null, id);
    }


    @Override
    public String toString() {
        return "===============================" +
                "\nчлен семьи: " + lastName + " " + firstName +
                "\nпол: " + getGender() +
                "\nположение: " + getPosition() +
                "\nсоциальный статус: " + getSocialPosition() +
                "\nобразование: " + getFondation() +
//                "\nКто дети: " + children +
                "\nдоходы: " + income +
                "\nвозраст: " + getAge() +
                "\nid: " + id +
                "\n===============================";

    }
    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public String getFondation() {
        if (fondation.equals(Fondation.Non_formal)){
            return "начальное";
        } else if (fondation.equals(Fondation.Formal)) {
            return "степень";
        } else if (fondation.equals(Fondation.Informal)) {
            return "профессиональное";
        };
        return null;
    }

    public String getPosition() {
        if (position.equals(Position.Father)){
            return "отец";
        } else if (position.equals(Position.Mother)) {
            return "мать";
        } else if (position.equals(Position.Son)) {
            return "сын";
        } else if (position.equals(Position.Daughter)) {
            return "дочь";
        } else if (position.equals(Position.Child)) {
            return "ребёнок";
        };
        return null;
    }

    public String getGender() {
        if (gender.equals(Gender.Male)){
            return "муж.";
        } else if (gender.equals(Gender.Female)) {
            return "жен.";
        };
        return null;
    }

    public String getSocialPosition() {
        if (socialPosition.equals(SocialPosition.Married)){
            return "в браке";
        } else if (socialPosition.equals(SocialPosition.Not_married)) {
            return "не в браке";
        };
        return null;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }


    @Override
    public void setId(double v) {
    }

    @Override
    public double setId() {
        return id;
    }



}

