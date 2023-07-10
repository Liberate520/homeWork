import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable {
    private String surname, name, patronymic;
    private Gender gender;
    private LocalDate birth, death;
    private Human mother, father;
    private List<Human> children;

    private int getAge(LocalDate birth, LocalDate death){
        int age;
        int birthYear = birth.getYear();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();
        if (death == null){
            LocalDate date = LocalDate.now();
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if (birthMonth == month) {
                if (day >= birthDay) age = year - birthYear;
                else age = year - birthYear - 1;
            }
            if (month > birthMonth) age = year - birthYear;
            else age = year - birthYear - 1;
        }
        else {
            int deathYear = death.getYear();
            int deathMonth = death.getMonthValue();
            int deathDay = death.getDayOfMonth();
            if (birthMonth == deathMonth) {
                if (deathDay >= birthDay) age = deathYear - birthYear;
                else age = deathYear - birthYear - 1;
            }
            if (deathMonth > birthMonth) age = deathYear - birthYear;
            else age = deathYear - birthYear - 1;
        }
        return age;
    }

    public Human(String surname, String name, String patronymic, Gender gender, int birthYear, int birthMonth, int birthDay) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birth = LocalDate.of(birthYear, birthMonth, birthDay);
        this.death = null;
        this.getAge(birth, death);
    }

    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getChildren() {
        return children;
    }
    public String getChildrenToString() {
        return children.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }

    public Human getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString(){
        return "ФИО: " + surname + " " + name + " " + patronymic + "; " + "ДР: " + birth + "; " + "Возраст: " + getAge(birth, death);

    }
}