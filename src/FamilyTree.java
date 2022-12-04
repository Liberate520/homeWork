import java.util.ArrayList;

public class FamilyTree<T> implements MethodsWorking{

    private static int id = 1;
    private ArrayList<T> treeHuman = new ArrayList<T>();

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        FamilyTree.id = id;
    }

    public ArrayList<T> getTreeHuman() {
        return treeHuman;
    }
    public void setTreeHuman(ArrayList<T> treeHuman) {
        this.treeHuman = treeHuman;
    }

    public void setTreeHuman(T treeHuman) {
        this.treeHuman.add(treeHuman);
    }

    // вывод в виде дерева
    public void preOrder(T tree, String space) {
        if (tree != null)
            System.out.println(space + ((Human)tree).getName());
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < ((Human)tree).getSon().size(); i++){
            if (((Human)tree).getSon().get(i).getH2() != null && ((Human)tree).getSon().get(i).getH2().getId() > ((Human)tree).getId()) {
                preOrder((T) ((Human)tree).getSon().get(i).getH2(), space + "  ");
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
