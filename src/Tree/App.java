package Tree;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Person pa = new Person("Artur","Gikramin", "Maratovich","27/02/1994",
                Gender.Man);
        Person ma = new Person("Nailay","Gikramina", "Maratovna","30/12/1996",
                Gender.Female);
        Person so = new Person("Mira","Gikramina", "Arturovna","07/07/2021",
                Gender.Female);
        Person dot = new Person("Tatiana","Dytlova", "Alaxandrovna","01/07/2004",
                Gender.Female);
        Person vot = new Person("Yana","Butco", "Sergeevna","15/01/1984",
                Gender.Female);

        tree.addLink(pa,ma,Relations.Husband,Relations.Wife);
        tree.addLink(pa,so,Relations.Father,Relations.Daughter);
        tree.addLink(pa,dot,Relations.Brother,Relations.Sister);
        tree.addLink(ma,so,Relations.Mother,Relations.Daughter);
        tree.addLink(ma,dot,Relations.Sister,Relations.Sister);
        tree.addLink(dot,so,Relations.Aunt,Relations.Niece);
        tree.addLink(vot,dot,Relations.Sister,Relations.Sister);

        System.out.println("-------------------\n");
        System.out.println(tree);
        System.out.println("-------------------\n");
//        Research.getRelation(pa,tree);
//        System.out.println("-------------------\n");
//        Research.getRelation(dot,tree);
//        System.out.println("-------------------\n");
//        Research.getRelation(dot,tree);
        System.out.println("-------------------\n");
        Research.getRelation(Relations.Sister, tree);
        System.out.println("-------------------\n");
        Research.getRelation(vot, Relations.Father, tree);

    }
}