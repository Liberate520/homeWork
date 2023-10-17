import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    public List<Human> humanList;
    public List<Human> childrenList;
    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
        }
    }
    public void addMother(Human human){

    }
    public void addFather(Human human){

    }
//TODO убрать все проверки, позже - заменить на логирование
    public void addChild(Human parent, Human child){
        if (!parent.getChildren().contains(child)){
            System.out.println("проверка два");
            parent.setChildren(child);
        }
        else System.out.println("что-то не так");
        //TODO настроить ничегонеделание, если ребёнок уже добавлен
    }//TODO добавить автоматическое добавление родителя к ребёнку по полу.
    public void getMarried(Human wife, Human husband ){


    }
    public String getFamilyTree(){
        StringBuilder humanStringBuilder = new StringBuilder();
        humanStringBuilder.append("Серейное древо: \n");
        for (Human human: humanList){
            humanStringBuilder.append(human);
            humanStringBuilder.append("\n");
        }
        return humanStringBuilder.toString();
    }

}
