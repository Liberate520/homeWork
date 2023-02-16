import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Human> familyTree;

    public FamilyTree(){ 
        this.familyTree = new ArrayList<>(); 
    }

    public boolean add(Human human){
        if(!familyTree.contains(human)){
            familyTree.add(human);
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for(Human human: familyTree){
            if(human.getFirstname().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        String info = "";
        for(Human human: familyTree){
            info += human + "\n";
        }
        return info;
    }

    public ArrayList<Human> getFamilyTree(){
        return familyTree;
    }
}
