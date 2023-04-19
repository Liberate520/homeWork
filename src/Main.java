package java_oop_homeWork.src;

public class Main {
    public static void main(String[] args) {

        Kinsman firstKinsman = new Kinsman("Рюрик", Sex.men);
        System.out.println(firstKinsman);
        Kinsman secondKinsman = new Kinsman("Анна", Sex.women);
        FamilyTree familyTree = new FamilyTree("Рюрики", firstKinsman);
        System.out.println(familyTree);
        familyTree.printFamily();
        familyTree.addParent(firstKinsman, secondKinsman);
        familyTree.printFamily();
        secondKinsman.printScions();
    }
}