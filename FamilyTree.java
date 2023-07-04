import java.util.List;

public class FamilyTree{
    int id;
    int humanId;
    List<Human> humanList;
    public void addHuman(Human human){
        human.setId(humanId++);
        humanList.add(human);
    }
    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for(Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}