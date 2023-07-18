package familyTree.model.service;

import familyTree.model.group.Group;
import familyTree.model.human.Human;

import java.time.LocalDate;

public class Service  {
    private int idHumon;
    private Group<Human> group;

    public Service() {
        group = new Group<>();
    }

    public void addHuman(String surname, String name, LocalDate dateOfBirthday, LocalDate dateOfDeath, String father, String mother){
        Human human = new Human(idHumon++, surname, name, dateOfBirthday, null, father, mother);
        group.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Human human: group){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){
        group.sortByAge();
    }
}
