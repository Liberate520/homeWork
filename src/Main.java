public class Main {
    public static void main(String[] args) {

    
        FamilyTree familyTree = new FamilyTree();

        Human daria = new Human("Дарья");
        Human evgenii = new Human("Евгений");

        Human nikita = new Human("Никита", evgenii, daria);

        daria.addChildren(nikita.getName());
        evgenii.addChildren(nikita.getName());


        familyTree.addHuman(nikita);
        familyTree.addHuman(evgenii);
        familyTree.addHuman(daria);

        System.out.println(daria);
        System.out.println(nikita);
        System.out.println(evgenii);

    }
}