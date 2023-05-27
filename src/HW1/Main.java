package HW1;

public class Main {
    public static void main(String[] args) {
        FamilyTree ruriks = new FamilyTree();
        ruriks.addPersonInFamilyTree(new Human("Рюрик"));
        ruriks.addPersonInFamilyTree(new Human("Игорь"),"Рюрик");
        ruriks.addPersonInFamilyTree(new Human("Ольга"));
        ruriks.addPersonInFamilyTree(new Human("Святослав"),"Игорь","Ольга");
        ruriks.addPersonInFamilyTree(new Human("Олег"),"Святослав");
        ruriks.addPersonInFamilyTree(new Human("Владимир"),"Святослав");
        ruriks.addPersonInFamilyTree(new Human("Ярополк"),"Святослав");



        ruriks.showChildren("Рюрик");
        ruriks.showChildren("Игорь");
        ruriks.showChildren("Святослав");
        ruriks.showParents("Святослав");
        System.out.println(ruriks.getPerson("Игорь"));

    }
}
