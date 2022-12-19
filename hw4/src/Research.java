public class Research {


    public static void getRelationFamily(Essence person, Relation relation, FamilyTree familyTree) {
        for (Communication el :
                familyTree.getFamily()) {
            if (el.getEssense1().getName().equals(person.getName()) && el.getRelation() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getRelationFamily(Relation relation, FamilyTree familyTree) {
        for (Communication el :
                familyTree.getFamily()) {
            if (el.getRelation() == relation) {
                System.out.println(el);
            }
        }
    }
}

