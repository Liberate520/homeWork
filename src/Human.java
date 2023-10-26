import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Human mother;
    private List<Human> children;

    public Human(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        List<Human> children = new ArrayList<>();
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathday() {
        return deathday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getChildren() {
        if (!(this.children).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Дети: ");
            stringBuilder.append(this.children);
            return stringBuilder.toString();
        }
        return null;
    }

    public String toString() {
        return "id: " + id + ", name: " + name + ", surname: " + surname;
    }
}