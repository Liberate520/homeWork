package builder;

import human.Gender;
import human.Human;

public class HumanBuilder {
    public Human build (String name, String surname, Gender gender) {
        Human human = new Human(name, surname, gender);
        return human;
    }
}
