public class Main {
    public static void main(String[] args) {
        FamilyTree family1 = new FamilyTree();
        Human mother1 = new Human("Vi", "Sol", Gender.Female, "30");
        Human father1 = new Human("Vo", "Sol", Gender.Male, "29");
        Human child1 = new Human("Tr", "Sol", Gender.Male, "10");
        Animal dog1 = new Animal("Zeus", "grey", TypeAnimal.Dog);
        Animal cat1 = new Animal("Mars", "white", TypeAnimal.Cat);
        Animal dog2 = new Animal("Naomi", "black", TypeAnimal.Dog);
        
        family1.addRelation(father1, mother1, Relation.Husband);
        family1.addRelation(mother1, father1, Relation.Wife);
        family1.addRelation(child1, father1, Relation.Son);
        family1.addRelation(child1, dog1, Relation.Owner);
        family1.addRelation(child1, cat1, Relation.Owner);

        FamilyTree family2 = new FamilyTree();
        family2.addRelation(dog1, dog2, Relation.Father);

        printFamily(family2);
        printFamily(family1);

        Research.getRelationFamily(mother1, Relation.Wife, family1);
        Research.getRelationFamily(Relation.Father, family2);

    }
    private static void printFamily(FamilyTree f1) {
        for (Communication el : f1) {
            System.out.println(el);
        }
        System.out.println("---------------------------");
    }
}