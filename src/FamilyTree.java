import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humansID;
    private List<Human> humanList;

    public FamilyTree() {this(new ArrayList<>());}

    public FamilyTree(List<Human> humanList) {this.humanList = humanList;}

    public Human getHumanByName(String humanName){
        for (Human human: humanList){
            if (human.getName().equals(humanName)) return human;
        }
        return  null;
    }
    public boolean add(Human human){
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansID++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }
    public Human getById(long id){
        if(!checkId(id)) return null;
        for (Human human : humanList){if(human.getId() == id) {return human;}}
        return null;
    }
    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if(human == null) return  null;

        List<Human> res = new ArrayList<>();
        for(Human parent : human.getParents()){
            for(Human child : parent.getChildren()){
                if(!child.equals(human) && !res.contains(child)) res.add(child);
            }
        }
        return res;
    }
    private void addToParents(Human human){
        for (Human parent : human.getParents()) parent.addChild(human);
    }
    private void addToChildren(Human human){
        for(Human child : human.getChildren()) child.addParent(human);
    }
    private boolean checkId(long id) {return id < humansID && id >= 0;}
    public String getInfo(){
        StringBuilder inf = new StringBuilder();
        inf.append("В древе ");
        inf.append(humanList.size());
        inf.append(" объектов: \n");
        for(Human human : humanList){
            inf.append(human);
            inf.append("\n");
        }
        return inf.toString();
    }

    @Override
    public String toString() {return getInfo();}
}