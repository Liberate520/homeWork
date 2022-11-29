import human.Human;

import java.util.ArrayList;
//лист всей семьи +
//реализация метода поиска челвоека по имени +
//добавление нового ребенка +
public class TreeFamily implements IThree {
    private ArrayList<Human> treeFamily = new ArrayList<>();
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
    public void addChildren(Human baby, Human father, Human mother) {
        baby.setPerent1(father);
        baby.setPerent2(mother);
        father.addChildren(baby);
        mother.addChildren(baby);
    }
    @Override
    public void searchHuman(String name) {
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getName() == name) {
                System.out.println(tList.get(i));
            }
        }
    }


}

