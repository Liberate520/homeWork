import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private Gender gender;
    private LocalDate birthDate;

    private String name;

    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.name = name;

        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }
}