package homeWork.family_tree.model.service;

import homeWork.family_tree.model.family_tree.FamilyTree;
import homeWork.family_tree.model.human.Gender;
import homeWork.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private int humanId;
    private FamilyTree<Human> humanList;

    public Service() {
        humanList = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        humanList.add(new Human(name, gender, birthDate));
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Получить список членов семьи:\n");
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humanList.sortByName();
    }

    public void sortByBirthDate(){
        humanList.sortByBirthDate();
    }

    public void loadFamily() { humanList.loadFamily(); }

    public void saveFamily() { humanList.saveFamily(); }
}
