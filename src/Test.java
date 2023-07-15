public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Александр", Gender.Male);
        Person p2 = new Person("Александра", Gender.Female);
        Person p3 = new Person("Олег", Gender.Male, p2, p1);
        Person p4 = new Person("Петр", Gender.Male, p2, p1);
        FamilyTree tree = new FamilyTree();
        tree.setPerson(p1, p2, p3, p4);
        System.out.println(tree.showAllTree());
        tree.showParents(p4);
        tree.showBrothersAndSisters(p3);
    }
}
