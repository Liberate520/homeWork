package Human;

import Human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int id;

    public Human build(String name, LocalDate bd, Gender gender) {
        Human human = new Human(id++, name, bd, gender);
        return human;
    }
}
