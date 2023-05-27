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


        ruriks.getPerson("Рюрик").showChildren();
        ruriks.getPerson("Ольга").showChildren();
        ruriks.getPerson("Игорь").showChildren();
        ruriks.getPerson("Святослав").showChildren();
        System.out.println(ruriks.getPerson("Игорь"));

    }
}
