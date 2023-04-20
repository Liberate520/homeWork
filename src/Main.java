package OOPjavaTree.src;

import OOPjavaTree.src.Data.OperationData;
import OOPjavaTree.src.Data.Operation;
import OOPjavaTree.src.Person.Human;
import OOPjavaTree.src.Service.Service;
import OOPjavaTree.src.Tree.Branches;
import OOPjavaTree.src.Tree.Tree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree branches = new Branches();
        Service service = new Service(branches);
        service.add("Дмитрий", 1980);
        service.add("Кристина", 1982);
        service.add("Василиса", 2001, service.getByName("Дмитрий"), service.getByName("Кристина"));
        service.add("Евгений", 2004, service.getByName("Дмитрий"), service.getByName("Кристина"));
        service.add("Леонид", 2008, service.getByName("Дмитрий"), service.getByName("Кристина"));

        //tree.toString() - для общего вывода списка дерева
        System.out.println(service);

        //human.getString() - Вывод после запроса детальной информации
        for (Human human : branches) {
            System.out.println(human.getString());
        }
        System.out.println();

        /*Operation file = new OperationData();
        service.saveData(file);*/
        Operation file = new OperationData();
        branches = (Tree) service.loadData(file);
        service.setTree(branches);
        service.sortByName();
        System.out.println(branches);
        service.sortByDate();
        System.out.println(branches);


    }
}