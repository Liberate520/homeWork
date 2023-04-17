public class Program {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human h1 = new Human("Natalia");
        Human h2 = new Human("Timur");
        tree.addMember(h1);
        tree.addMember(h2);
        tree.showAllMembers();
        
        Human h3 = new Human("Liza");
        tree.addMember(h3);
        Human h4 = new Human("Lenya");
        tree.addMember(h4);
        tree.showAllMembers();
        h1.addChild(h3);
        h1.addChild(h4);
        h2.addChild(h3);
        h2.addChild(h4);
        h1.showChildren();
        h2.showChildren();
    }
}
