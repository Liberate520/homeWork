package homeWork;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;
    public FamilyTree(){
        this.humanList = humanList;
    }
    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            return  true;}
            addToParents(human);
            addToChildren(human);
        return  false;
    }
    private void addToParents(Human human){
         for (Human parent: human.getParents()){
            parent.addParent(human);
        }
    }
    private void addToChildren(Human human){
       for (Human children: human.getChildren()){
            children.addParent(human);
        }
    }
    public Human getByName(String name){
        for (Human human: humanList){
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n ");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }

}
