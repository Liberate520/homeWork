package family_tree.service;

import java.time.LocalDate;

import family_tree.human_family.HumanGroup;
import family_tree.humans.Gender;
import family_tree.humans.Human;

public class Service {
    private HumanGroup humanGroup;

    public Service() {
        humanGroup = new HumanGroup();
    }

    public void HumanGroup(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        humanGroup.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди:");
        for (Human human : humanGroup) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        humanGroup.sortByName();
    }

    public void sortByYear() {
        humanGroup.sortByYear();
    }
}
