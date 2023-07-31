import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {

    private String name;
    private Gender gender;
    private Human Father;
    private Human Mather;
    private String children;
    private LocalDate birthday;
    private LocalDate deathday;

    public Human(String name, Gender gender, Human Father, Human Mather, String children, LocalDate birthday, LocalDate deathday) {
        this.name = name;
        this.gender = gender;
        this.Father = Father;
        this.Mather = Mather;
        this.children = children;
        this.birthday = birthday;
        this.deathday = deathday;
    }




    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return Father;
    }

    public Human getMather() {
        return Mather;
    }

    public String getChildren() {
        return children;
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    @Override
    public String toString() {
        return "Имя: " + getName() + ", Пол: " + getGender() + " Отец: " + getFather() + ", Мать: " + getMather() + " Дети: " + getChildren() + ", Дата рождения: " + getBirthday();
    }


}
