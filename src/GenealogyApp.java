import java.util.List;





public class GenealogyApp {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Smith", Gender.MALE, 1980, 2022);
        Person person2 = new Person("Alice", "Johnson", Gender.FEMALE, 1915, 2005);
        Person person3 = new Person("Bob", "Brown", Gender.MALE, 2000, -1);
        Person person4 = new Person("Emma", "Davis", Gender.FEMALE, 2010, -1);
        Person person5 = new Person("Michael", "Miller", Gender.MALE, 1975, -1);

        person1.addChild(person2);
        person1.addChild(person3);
        person2.addChild(person4);
        person2.addChild(person5);

        person1.addRelationship(person2, RelationshipType.PARENT);
        person2.addRelationship(person1, RelationshipType.CHILD);

        FamilyTree familyTree = new FamilyTree(person1);

        List<Relationship> relationships = familyTree.getAllRelationships();
        for (Relationship relationship : relationships) {
            System.out.println(
                    relationship.getPerson1().getFullName() + " is " +
                            relationship.getType() + " of " +
                            relationship.getPerson2().getFullName()
            );
        }
        System.out.println("Age " + person1.getFullName() + ": " + person1.getAge() + " years");

        if (person1.isAlive()) {
            System.out.println(person1.getFullName() + " Alive.");
        } else {
            System.out.println("Died at " + person1.getDeathYear());
            System.out.println("Time since death " + person1.getFullName() + ": " + person1.getYearsSinceDeath() + " years");
        }
    }
}
