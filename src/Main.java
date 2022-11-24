
public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        Human h1 = new Human("Человек1", 25, Gender.мужской);
        tree.setTreeHuman(h1);
        Human h2 = new Human("Человек2", 5, Gender.мужской);
        tree.setTreeHuman(h2);
        Human h3 = new Human("Человек3", 4, Gender.женский);
        tree.setTreeHuman(h3);

        h1.addСommunications(h2, TypeCommunications.отец, TypeCommunications.ребенок);
        h1.addСommunications(h3, TypeCommunications.отец, TypeCommunications.ребенок);

        h1.getInfo();
        h2.getInfo();
        h3.getInfo();
        //System.out.println(FamilyTree.getId());
        tree.getInfo();

    }
}
