import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id;
    private int humanId;
    private List<Human> humanList;
    private List<Human> cildrenList;
    
    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
        cildrenList= new ArrayList<>();
    }
    public void addHuman(Human human) {
        human.setId(humanId++);
        humanList.add(human);
    }

    public void addCildren(Human humanP,Human humanC){
        this.cildrenList.add(humanC);
        this.cildrenList.add(humanP);
    }
    public String getHumansInfo() {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей дерева:\n");
        //String str=null;
        for (Human human : humanList) {         
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
   
}
