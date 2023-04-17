public class Program {
    public static void main(String[] args) {
        System.out.println("hi");
        FamilyTree tree = new FamilyTree();
        Human h1 = new Human("Natalia");
        tree.addMember(h1);
        tree.showAllMembers();
        
        Human h3 = new Human("Liza");
        tree.addMember(h3);
        tree.showAllMembers();
        h1.addChild(h3);
        h1.showChildren();
    }
}
