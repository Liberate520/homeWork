public class Main_of_tree {
    public static void main(String[] args) {
        HumanTree humanTree = new HumanTree();
        Human firstHuman = new Human("Romanov Michael Fedorovich", "1596-1645", "1613-1645", null, null,
                new String[] { "Romanov Alexey Michaelevich" });
        Human secondHuman = new Human("Streshneva Evdokiya", "1608-1645", null, null, null,
                new String[] { "Romanov Alexey Michaelevich" });
        Human thirdHuman = new Human("Romanov Alexey Michaelevich", "1629-1676", "1645-1676", firstHuman, secondHuman,
                new String[] { "Romanov Fedor Alexeevich", "Romanova Sofia Alexeevich", "Ivan 5 Alexeevich",
                        "Romanov Petr 1 Alexeevich" });
        Human fourthHuman = new Human("Romanov Fedor Alexeevich", "1661-1682", "1676-1682", thirdHuman, null, null);
        Human fifthHuman = new Human("Romanova Sofia Alexeevich", "1657-1704", "1682-1689", thirdHuman, null,
                new String[] { "Romanov Fedor Alexeevich", "Romanova Sofia Alexeevich", "Romanov Petr 1 Alexeevich" });
        humanTree.addHuman(firstHuman);
        humanTree.addHuman(secondHuman);
        humanTree.addHuman(thirdHuman);
        humanTree.addHuman(fourthHuman);
        humanTree.addHuman(fifthHuman);

        System.out.println(firstHuman.toString());
        System.out.println(humanTree.getHumanList());
        System.out.println(thirdHuman.father());
        System.out.println(thirdHuman.getComunity());
        System.out.println(fourthHuman.getComunity());
    }
}
