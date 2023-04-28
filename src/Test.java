public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        String path = "/home/evgen/prog/homeWork/familyTree.txt";
        FileWriteRead fileWriteRead = new FileWriteRead();
//        fileWriteRead.write(familyTree, path);
        familyTree = fileWriteRead.read(path);



        System.out.println(familyTree.getFamilyInfo());
    }
}
