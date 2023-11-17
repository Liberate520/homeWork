package Service;

import Builder.HumanBuilder;
import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private HumanBuilder builder;

    public Service() {
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender, Human parent1, Human parent2){
        Human human = builder.build(lastname, name, birthday, dayOfDeath, gender, parent1, parent2);
        familyTree.addHuman(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family: \n");
        for(Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
//    public void sortByName(){
//        familyTree.sortByName();
//    }
//    public void sortByAge(){
//        familyTree.sortByAge();
//    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }
}
