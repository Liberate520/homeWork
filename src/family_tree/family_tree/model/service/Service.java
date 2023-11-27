package family_tree.family_tree.model.service;

import family_tree.family_tree.model.FamilyTree;
import family_tree.family_tree.model.Gender;
import family_tree.family_tree.model.human.Human;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private int index;
    private FamilyTree familyTree;
    private List<Human> humanList;

    public Service(){
        FamilyTree familyTree;
        List<Human> humanList;
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (Human human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
//    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender){
//        Human human = new Human(name, birthDate, deathDate, gender);
    public void addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = new Human(name, gender, birthDate, null, null, null);
        familyTree.addHuman(human);
    }
//    public void addHuman(String name, LocalDate birthDate, Gender gender){
//        Human human = new Human(name, birthDate, null, gender);
    public void addHuman(String name, Gender gender, LocalDate birthDate,
                         Human father, Human mother){
        Human human = new Human(name, gender, birthDate, null, father, mother);
        familyTree.addHuman(human);
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
//        Human human = new Human(name, birthDate, deathDate, gender);
        Human human = new Human(name, gender, birthDate);
        familyTree.addHuman(human);

    }
}
