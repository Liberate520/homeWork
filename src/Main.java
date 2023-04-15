public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human man = new Human(Gender.Male, "Ivan", "Ivanov", null, null);
        Human woman = new Human(Gender.Female, "Olga", "Ivanova", null, null);
        familyTree.addMember(man);
        familyTree.getMarried(man, woman);
        Human chaild1 = new Human(Gender.Female, "Masha");
        familyTree.addChaild(man, chaild1);
        Human chaild2 = new Human(Gender.Male, "Kolya");
        familyTree.addChaild(woman, chaild2);
        System.out.println(familyTree.getInfoByMember(man));
        System.out.println(familyTree.getInfoByMember(woman));
        Human man1 = new Human(Gender.Male, "Sergey", "Sergeev", null, null);
        familyTree.getMarried(chaild1, man1);
        System.out.println(familyTree.getInfoByMember(man1));
        System.out.println(familyTree.getInfoByMember(chaild1));
        System.out.println(familyTree.getParents(chaild1));
        System.out.println(familyTree.getBrothersAndSisters(chaild2));
        System.out.println(familyTree.getPartner(man1));

    }
}
