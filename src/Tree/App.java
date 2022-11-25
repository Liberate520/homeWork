package Tree;

public class App {
    /**
     *
     * App Тело программы. В нем созданы несколько личностей, назначены им родственные связи
     * и приведен вызов вункций исследования.
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        Person pa = new Person("Valetov", "Vasiliy","Innokentievich","11/07/1940",
                Gender.Man);
        Person ma = new Person("Valetova","Elena", "Petrovna","24/03/1943",
                Gender.Female);
        Person so = new Person("Valetov", "Andrey","Vasilievich","30/10/1972",
                Gender.Man);
        Person dot = new Person("Voynash","Tamara", "Vasilevna","20/11/1966",
                Gender.Man);



        tree.addLink(pa,ma,Relations.Husband,Relations.Wife);
        tree.addLink(pa,so,Relations.Father,Relations.Son);
        tree.addLink(pa,dot,Relations.Father,Relations.Daughter);
        tree.addLink(ma,so,Relations.Mother,Relations.Son);
        tree.addLink(ma,dot,Relations.Mother,Relations.Daughter);
        tree.addLink(so,dot,Relations.Brother,Relations.Sister);


        System.out.println("-------------------\n");
        System.out.println(tree);
        System.out.println("-------------------\n");
        Research.getResearch(pa,tree);
        System.out.println("-------------------\n");
        Research.getResearch(dot,tree);
        System.out.println("-------------------\n");
        Research.getResearch(so,tree);
        System.out.println("-------------------\n");
        Research.getResearch(Relations.Sister, tree);
        System.out.println("-------------------\n");
        Research.getResearch(Relations.Husband, pa, tree);




    }
}