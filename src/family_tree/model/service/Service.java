package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;

import family_tree.model.human.Human;
import family_tree.model.human.Gender;

import java.time.LocalDate;

public class Service {
    private long id;
    private FamilyTree<Human> familyTree;

    public void addHuman(String firstName, String lastName, LocalDate birthDate, Gender sex) {
        Human human = new Human(firstName, lastName, birthDate, sex);
        familyTree.addHuman(human);
    }
    public Service() {

        familyTree = new FamilyTree<>();
    }
//public String getStudentInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Студенты:\n");
//        for (Human human: familyTree) {
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }


    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди: \n");
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
    public void sortByDateBirth() {
        familyTree.sortByDateBirth();
    }
    public void sortByAgeByFirstName() {
        familyTree.sortByAgeByFirstName();
    }


}
