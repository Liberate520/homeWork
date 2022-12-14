package Human;

import java.util.ArrayList;

public class WorkTreeFamily implements IWorkTreeFamily {
    private ArrayList<Human> treeFamily = new java.util.ArrayList<>();
    public ArrayList<Human> getTreeFamily() {
        return treeFamily;
    }
    public void setTreeFamily(ArrayList<Human> treeFamily) {
        this.treeFamily = treeFamily;
    }
    @Override
    public void addTreeFamily(Human human){
        treeFamily.add(human);
    }
    @Override
    public void addChildren(Human baby, Human parent1, Human parent2) {
        baby.setParent1(parent1);
        baby.setParent2(parent2);
        parent1.addChildren(baby);
        parent2.addChildren(baby);
    }
    @Override
    public Human loopHuman(String name){
        Human human = new Human(null,0);
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            if (treeFamily.contains(name)) {
                human = tList.get(i);
            }
        }
        return human;
    }
    @Override
    public void allHuman(){
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            System.out.println(tList.get(i));
        }
    }
}
