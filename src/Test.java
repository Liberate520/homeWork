public class Test {
    public static void main(String[] args)
    {
        Human h1 = new Human("ivan", "karp", 1980, Gender.Male);
        Human h2 = new Human("galina", "schuka", 1983, Gender.Female);

        h1.addChild("vasiliy", 1999, Gender.Male, h2);
        h2.addChild("valentina", 2003, Gender.Female, h1);

        Tree tree = new Tree(h1);

        tree.getChildren();
        tree.nextHuman(0);
        tree.nextHuman(5);
    }
}
