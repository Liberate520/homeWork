package familyTree.src;

import java.util.*;

public class FamilyTree{
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }
    //TODO метод поиска братьев
    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }
    public Human getByName(String name) {
        for (Human human: humanList) {
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }
}
