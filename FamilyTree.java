import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> humanList;
    public FamilyTree() {this(new ArrayList<>());}

    public FamilyTree(List<Human> humanList) {this.humanList = humanList;}

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if(human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        System.out.println("В дереве " + humanList.size() + " объекта/ов: ");
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < humanList.size(); i++){
                sb.append("\n");
                sb.append(humanList.get(i).getInfo());
            }
    return sb.toString();
    }
    }

   
   
    

