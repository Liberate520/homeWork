package home_work_class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humansList;

    public FamilyTree() {
        humansList = new ArrayList<>();
    }

    public String showHumansList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----Список корневого древа-----\n");
        for (Human human: humansList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        stringBuilder.append("-----Окончание списка корневого дерева-----\n");
        return stringBuilder.toString();
    }

    public void addHuman(Human human){
        if (! humansList.contains(human)){
            humansList.add(human);}
    }

    public Human findHumanByName(String name){
        for (Human human: humansList) {
            if (human.getName().equals(name)){return human;}
        }
        return null;
    }
}
