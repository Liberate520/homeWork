package OOPjavaTree.src;

import OOPjavaTree.src.Data.OperationData;
import OOPjavaTree.src.Data.Operation;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree tree = new Tree();

        tree.add(new Human("Дмитрий23", 1980));
        tree.add(new Human("Кристина", 1982));
        tree.add(new Human("Василиса", 2001, tree.getByName("Дмитрий"), tree.getByName("Кристина")));
        tree.add(new Human("Евгений", 2004, tree.getByName("Дмитрий"), tree.getByName("Кристина")));
        tree.add(new Human("Леонид", 2008, tree.getByName("Дмитрий"), tree.getByName("Кристина")));

        //tree.toString() - для общего вывода списка дерева
        System.out.println(tree);

        //human.getString() - Вывод после запроса детальной информации
        for (Human human : tree.getFamBranch()) {
            System.out.println(human.getString());
        }
        System.out.println();

        //Operation file = new OperationData();
        //tree.saveData(file, tree);
        Operation file = new OperationData();
        Tree tree1 = (Tree) tree.loadData(file);
        System.out.println(tree1);
    }
}