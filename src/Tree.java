import java.util.ArrayList;
import java.util.List;

public class Tree {
    List<Human> tree;
    
    public Tree(){
        this(new ArrayList<>());
    }

    private Tree(List<Human> tree){
        this.tree = tree;
    }

    public void addFamilyTree( Human human){
        this.tree.add(human);
    }
    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей в семейном древе:\n");
        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    // public static showTree(){
    //     StringBuilder stringBuilder = new StringBuilder();
    //     stringBuilder.append("Люди:");
    //     for (Human human : ) {
    //         stringBuilder.append(human);
    //         stringBuilder.append("\n");
    //     }
    //     return stringBuilder.toString();
    //     // System.out.println(tree);
    // }
}
