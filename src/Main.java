
public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human h1 = new Human("Человек1", 25, Gender.male);
        tree.setTreeHuman(h1);
        Human h2 = new Human("Человек2", 5, Gender.male);
        tree.setTreeHuman(h2);
        Human h3 = new Human("Человек3", 4, Gender.female);
        tree.setTreeHuman(h3);

        h1.addСommunications(h2, TypeCommunications.father, TypeCommunications.child);
        h1.addСommunications(h3, TypeCommunications.father, TypeCommunications.child);

        h1.getInfo();
        h2.getInfo();
        h3.getInfo();
        //System.out.println(FamilyTree.getId());
        tree.getInfo();

    }
}
