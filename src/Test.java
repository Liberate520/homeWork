public class Test {
    public static void main(String[] args) {
        Human grandMa = new Human("GrandMa", "GrandMa", 1960, Gender.Male);
        Human father = new Human("Ivan", "Ivanov", 1980, Gender.Male);
        Human mother = new Human("Irina", "Irinova", 1984, Gender.Female);
        mother.setMother(grandMa);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(mother);
        familyTree.addHuman(father);
        father.setPartner(mother);

        for (int i = 0; i < 3; i++) {
            Human child = new Human("child" + (i + 1), "child" + (i + 1),
                    2005 + i, i % 2 == 0 ? Gender.Male : Gender.Female);
            child.setFather(father);
            child.setMother(mother);
            familyTree.addHuman(child);
        }
        father.addChild(new Human("fatherChild", "fatherChild", 2008, Gender.Male));

        String path = "/home/evgen/prog/homeWork/familyTree.txt";
        FileWriteRead fileWriteRead = new FileWriteRead();
        fileWriteRead.write(familyTree, path);
        familyTree = fileWriteRead.read(path);

        System.out.println(familyTree.getFamilyInfo());
    }
}
