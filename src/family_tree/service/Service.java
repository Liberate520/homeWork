package family_tree.service;

import family_tree.family_tree.FamilyTree;

import family_tree.human.Human;

import java.time.LocalDate;

public class Service {
    private long id;
    private FamilyTree familyTree;
    public void addHuman(String firstName, String lastName, LocalDate birthDate, family_tree.human.Gender sex) {

        Human human = new Human(firstName, lastName, birthDate, sex);
        familyTree.addHuman(human);
    }
    public Service() {
        familyTree = new FamilyTree();
    }
    public String getStudentInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Студенты:\n");
        for (Human human: familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Люди: \n");
        for (Human human: familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByFirstName() {
        familyTree.sortByFirstName();
    }
    public void sortByLastName() {
        familyTree.sortByLastName();
    }
    public void sortByDataBirth() {
        familyTree.sortByDataBirth();
    }
}
