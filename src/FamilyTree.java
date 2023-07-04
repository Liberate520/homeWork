import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Human> humanList;

    public FamilyTree(ArrayList<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Human getByName(String fullName){
        for (Human human : humanList){
            if(human.getFullName().equals(fullName)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder build = new StringBuilder();
        build.append("In family tree: ");
        build.append(humanList.size());
        build.append(" people: \n");
        for (Human human : humanList){
            build.append(human.getInfo());
            build.append("\n");
        }

        return  build.toString();
    }
    @Override
    public String toString (){
        return getInfo();
    }

}
