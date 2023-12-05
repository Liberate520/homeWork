import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private static List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public static void addHuman(Human human){
        humanList.add(human);

//        addToChildren(human);
    }

//    private void addToChildren(Human human){
//        for (Human child: human.getChildren()){
//            child.
//        }
//    }

    public String toString(){return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


}
