public class Main {
    public static void main(String[] args) {
        FamilyTree family1 = new FamilyTree();
        Human mother1 = new Human("Vi", "Sol", Gender.Female, "30");
        Human father1 = new Human("Vo", "Sol", Gender.Male, "29");
        Human child1 = new Human("Tr", "Sol", Gender.Male, "10");

        Human mother2 = new Human("Kate", "Ivanova", Gender.Female, "30");
        Human father2 = new Human("Ivan", "Ivanov", Gender.Male, "29");
        Human child2 = new Human("Den", "Ivanov", Gender.Male, "10");
        Human child3 = new Human("Alisa", "Ivanova", Gender.Female, "10");
        Human child4 = new Human("Sveta", "Ivanova", Gender.Male, "10");

        family1.addRelation(father1, mother1, Relation.Husband);
        family1.addRelation(mother1, father1, Relation.Wife);
        family1.addRelation(child1, father1, Relation.Son);

        FamilyTree family2 = new FamilyTree();
        family2.addRelation(mother2, father2, Relation.Wife);
        family2.addRelation(father2, mother2, Relation.Husband);
        family2.addRelation(child2, father1, Relation.Son);
        family2.addRelation(child3, child2, Relation.Sister);
        family2.addRelation(child3, mother1, Relation.Daughter);
        family2.addRelation(child4, child2, Relation.Brother);
        
        System.out.println("Family1");
        System.out.println(family1);
        System.out.println("---------------");
        System.out.println("Family2");
        System.out.println(family2);

       
    }
}
