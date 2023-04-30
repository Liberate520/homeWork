public class Main {
    public static void main(String[] args) {
        FamilyTreeServices familyTreeServices = new FamilyTreeServices();
        String path = "/home/evgen/prog/homeWork/familyTree.txt";

//        for (int i = 0; i < 5; i++) {
//            familyTreeServices.addHumanToFamilyTree(familyTreeServices.createNewHuman());
//        }
//        familyTreeServices.getFamilyTreeInfo();
//        familyTreeServices.writeFamilyTreeInFile(path);

        familyTreeServices.setFamilyTree(familyTreeServices.readFamilyTreeFromFile(path));
        familyTreeServices.getFamilyTreeInfo();
    }
}
