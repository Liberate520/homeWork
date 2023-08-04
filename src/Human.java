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


    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", день рожденья: ");
        sb.append(birthday);
        sb.append("\n");

        return sb.toString();
    }


}