import human.Human;

import java.util.ArrayList;
//лист всей семьи +
//реализация метода поиска челвоека по имени +
//добавление нового ребенка +
public class TreeFamily {
    private ArrayList<Human> treeFamily = new ArrayList<>();
    public ArrayList<Human> getTreeFamily() {
        return treeFamily;
    }
    public void setTreeFamily(ArrayList<Human> treeFamily) {
        this.treeFamily = treeFamily;
    }
    public void addTreeFamily(Human human){
        treeFamily.add(human);
    }
    public void addChildren(Human baby, Human perent1, Human perent2) {
        //treeFamily.add(baby);
        baby.setPerent1(perent1);
        baby.setPerent2(perent2);
        perent1.addChildren(baby);
        perent2.addChildren(baby);
    }

    public void searchHuman(String name) {
        ArrayList<Human> tList = getTreeFamily();
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getName() == name) {
                System.out.println(tList.get(i));
            }
        }
    }
}

