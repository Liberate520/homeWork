import java.util.ArrayList;

public class FamilyTree implements MethodsWorking{

    private static int id = 1;
    private ArrayList<Human> treeHuman = new ArrayList<Human>();

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        FamilyTree.id = id;
    }

    public ArrayList<Human> getTreeHuman() {
        return treeHuman;
    }
    public void setTreeHuman(ArrayList<Human> treeHuman) {
        this.treeHuman = treeHuman;
    }

    public void setTreeHuman(Human treeHuman) {
        this.treeHuman.add(treeHuman);
    }

    // вывод в виде дерева
    public void preOrder(Human tree, String space) {
        if (tree != null)
            System.out.println(space + tree.getName());
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < tree.getSon().size(); i++){
            if (tree.getSon().get(i).getH2() != null && tree.getSon().get(i).getH2().getId() > tree.getId()) {
                preOrder(tree.getSon().get(i).getH2(), space + "  ");
            }else{return;}
        }
    }

    @Override
    public void getInfo() {
        if (this.treeHuman.size() == 0){
            System.out.println("В дереве нет элементов...");
        }else{
            preOrder(treeHuman.get(0), "   ");
        }
    }
}
