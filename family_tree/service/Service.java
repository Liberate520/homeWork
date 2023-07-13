package family_tree.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import family_tree.model.human_family.FamilyTree;
import family_tree.model.human_family.HumanGroup;
import family_tree.model.humans.Gender;
import family_tree.model.humans.Human;

public class Service<T> {
    private HumanGroup humanGroup;
    private FamilyTree familyTree;
    private List<T> people;

    public Service() {
        humanGroup = new HumanGroup<>();

    }

    public String getHumansInfo() {
        return familyTree.getHumanInfo();

    }

    public void sortByYear() {
        familyTree.sortByYear();
    }

    public List<T> getPeopleByGender(Gender gender) {
        List<T> peopleByGender = new ArrayList<>();
        for (T person : people) {
            if (((Human) person).getGender() == gender) {
                peopleByGender.add(person);
            }
        }
        return peopleByGender;
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human<>(name, birthDate, gender);
        humanGroup.addHuman(human);
    }

}
