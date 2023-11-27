public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human nikita = new Human("Никита",32);
        Human gosha = new Human("Георгий",31);
        Parent yulia = new Parent("Юлия",50);
        Parent kostya = new Parent("Костя",49);


        yulia.addChildren(nikita);
        yulia.addChildren(gosha);
        familyTree.addHumanInTree(yulia);
        familyTree.addHumanInTree(nikita);
        familyTree.addHumanInTree(gosha);
        familyTree.addHumanInTree(kostya);
        System.out.println(familyTree.getFamilyTree());
        System.out.println(yulia.getChild());
    }
}
