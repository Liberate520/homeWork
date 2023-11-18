package family_tree.service;

import family_tree.family_tree.Family_tree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class Service {
    private Family_tree familyTree;

    public Service() {
        familyTree = new Family_tree();
    }

    public void AddHuman(String snils, String fam, String name, LocalDate dr, Gender gender){
        Human human = new Human(snils, fam, name, dr, gender);
        familyTree.AddHuman(human);

    }

    public String GetHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return GetHumanListInfo();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByFam(){
        familyTree.sortByFam();
    }

    public void sortByAge(){
        familyTree.sortByDr();
    }
}
