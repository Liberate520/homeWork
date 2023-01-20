public class MyProgram {
    public static void main(String[] args) {
        
        Persons p1 = new Persons("Vladimir",63);
        Persons p2 = new Persons("Dmitriy", 30);
        Persons p3 = new Persons("Afina", 5);

        MyTree tree = new MyTree();
        Service serviceTree = new Service(tree);

        tree.append(p1, p2);
        tree.append(p2, p3);

        for (Nodes nodes : tree) {
            System.out.println(nodes);
        }

        System.out.println();
        //serviceTree.sortByName();
        //System.out.println(new MyResearch(tree).spend(p2, Relationships.CHILDREN));

        
    }
    
}
