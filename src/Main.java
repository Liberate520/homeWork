public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human person1 = new Human("male", "Nicola", "Tesla");
        Human person2 = new Human("female", "Maria", "Tropicana");

        Human person3 = familyTree.createHuman("male", person1, person2, "Max");
        Human person4 = new Human("female", "Anna", "Verita");
        Human person5 = familyTree.createHuman("female", person3, person4, "Giulia");
        Human person6 = familyTree.createHuman("male", person3, person4, "Alessanro");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);
        System.out.println(person6);

    }

}