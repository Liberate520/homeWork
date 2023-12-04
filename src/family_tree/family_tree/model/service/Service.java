package family_tree.family_tree.model.service;

import family_tree.family_tree.model.*;
import family_tree.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private int index;
    private FamilyTree familyTree;
//    private Human[] humanList;
//    private List<Human> humanList;  // по замечанию - лишнее
//    public Service(){
//        FamilyTree familyTree;
//        List<Human> humanList;    }

    public Service(int index, FamilyTree familyTree) {
        this.index = index;
        this.familyTree = familyTree;
    }

//    public <G extends GeneralTypeTree<G>> void FamilyTree() {
//        FamilyTree<G> familyTree = new FamilyTree<>();
//    }

    public void FamilyTree () {
        FamilyTree familyTree = new FamilyTree<>();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");

        Iterable<? extends Human> humanList = null;               // ???
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
    // метод сохранения      save(tree);
    private static void save(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        fileHandler.save(tree, filePath);
    }
    // метод загрузки
    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }
}
