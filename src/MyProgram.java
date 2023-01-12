public class MyProgram {
    public static void main(String[] args) {
        
        Persons p1 = new Persons("Vladimir",63);
        Persons p2 = new Persons("Dmitriy", 30);

        MyTree tree = new MyTree();

        tree.append(p1, p2);

        System.out.println(new MyResearch(tree).spend(p2, Relationships.CHILDREN));
    }
    
}
