package model;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
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
        FileHandler fileHandler = new FileHandler(familyTree);
        fileHandler.output();
    }

    public void download() {
        FileHandler fileHandler = new FileHandler(familyTree);
        familyTree = fileHandler.input();
    }

    public void setParent(int idChild, int idParent) {
        for (Human humanChild: familyTree){
            if (humanChild.getId() == idChild){
                for (Human humanParent: familyTree){
                    if (humanParent.getId() == idParent){
                        humanChild.setParent(humanParent);
                    }
                }
            }
        }
    }
}
