import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
        public FamilyTree() {
        this(new ArrayList<>());
    }



    public FamilyTree(List<Human> humanList){
        this.humanList= humanList;

    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() !=null){
                human.getFather().addChild(human);
            }
            if (human.getMather() != null){
                human.getMather().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for(Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    

 
    public String getInfo(){
        
        return humanList.toString();
}



    public List<Human> getHumanList() {
        return humanList;
    }



    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }





}