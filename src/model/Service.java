package model;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileInOut fileHandler;

    public Service(FileInOut fileHandler) {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler(familyTree);
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthday){
        Human human = new Human(id, name, gender, birthday);
        familyTree.addHuman(human);
    }

    public String getHuman(int id){
        String humanInfo = "";
        for (Human human: familyTree){
            if(human.getId() == id){
                humanInfo = human.allInfo();
            }
        }
        return humanInfo;
    }

    public String getAllHuman(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: familyTree){
            stringBuilder.append(human.allInfo()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDay(){
        familyTree.sortByBirthDay();
    }

    public void save() {
        fileHandler.output();
    }

    public void download() {
        familyTree = fileHandler.input();
    }

    public void setParent(int idChild, int idParent) {
        familyTree.setParent(idChild, idParent);
    }
}
