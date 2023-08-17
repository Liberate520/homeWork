public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree.getAllHumans());
        FileOperationTXT fileOp = new FileOperationTXT();
        fileOp.write("test.txt",tree);
        fileOp.read("test.txt");
    }


    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human marya = new Human("Мария",Gender.FEMALE,"2000-03-12");
        Human prohor = new Human("Прохор",Gender.MALE, "1999-06-21");
        tree.addHuman(marya);
        tree.addHuman(prohor);
        tree.setWedding(marya,prohor);

        Human boris = new Human("Борис",Gender.MALE,
                "2018-07-23", marya,prohor);
        Human olesia = new Human("Олеся",Gender.FEMALE,
                "2020-12-05", marya,prohor);
        tree.addHuman(boris);
        tree.addHuman(olesia);

        Human pavel = new Human("Павел",Gender.MALE,"1968-07-23");
        pavel.addChild(prohor);
        tree.addHuman(pavel);

        return tree;
    }
}
