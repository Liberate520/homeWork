package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private List<Human> parents;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }
}

