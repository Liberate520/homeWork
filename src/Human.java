import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {

    private String name;
    private Gender gender;
    private String Father;
    private String Mather;
    private String children;
    private LocalDate birthday;

    public Human(String name, Gender gender, String Father, String Mather, String children, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.Father = Father;
        this.Mather = Mather;
        this.children = children;
        this.birthday = birthday;
    }




    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFather() {
        return Father;
    }

    public String getMather() {
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
