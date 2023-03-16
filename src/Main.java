import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        var tree = new FamilyTree();
        final Writable fileHandler = new FileHandler("FamilyTree.out");
        tree = (FamilyTree) fileHandler.read();

        System.out.println(tree.getInfo());
//        System.out.println("--- Отсортировано по фамилии ---");
//        tree.sortByName();
//        System.out.println(tree.getInfo());

        fileHandler.write(tree);
    }
}