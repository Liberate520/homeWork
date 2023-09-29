import familyTree.FamilyTree;
import human.*;
import java.time.LocalDate;
import static fileHandler.FileHandler.*;
import static fileHandler.FamilyTreeFileWriter.*;


public class Program {
    public static void main(String[] args) throws Exception {
//        FamilyTree tree = treeFamily();
//        System.out.println(tree);
//        treeSerialize(tree);
//        FamilyTree tree1 = treeDeserialize();
//        System.out.println(tree1);
//        System.out.println(tree1.getByFIO("Henry","Huse"));

//        FamilyTree tree = treeFamily();
//        System.out.println(tree);
//        saveFamilyTreeToFile(tree);
        FamilyTree tree = readFamilyTreeFromFile();
        System.out.println(tree);
    }

    public static FamilyTree treeFamily(){
        FamilyTree tree = new FamilyTree();

        Human grandMother1 = new Human("Huse", "Loura",
                LocalDate.of(1950, 04,10) ,
                LocalDate.of(2012,06,20),Gender.FEMALE);

        Human grandFather1 = new Human("Huse", "Henry",
                LocalDate.of(1947,05,20),Gender.MALE);

        Human grandMother2 = new Human("Tomson", "Mary",
                LocalDate.of(1950,04,10),
                LocalDate.of(2012,06,20),Gender.FEMALE);

        Human grandFather2 = new Human("Tomson", "Harry",
                LocalDate.of(1947,05,20),Gender.MALE);

        tree.add(grandMother1);
        tree.add(grandFather1);
        tree.add(grandMother2);
        tree.add(grandFather2);

        Human mother = new Human("Brown","Hillary",
                LocalDate.of(1990,02,17),Gender.FEMALE,grandMother1,grandFather1);

        Human father = new Human("Brown","John",
                LocalDate.of(1986,11,17), Gender.MALE,grandMother2,grandFather2);

        Human child1 = new Human("Brown","Bob",
                LocalDate.of(2010,03,1),Gender.MALE,mother,father);

        Human child2 = new Human("Brown","Gretta",
                LocalDate.of(2011,11,4),Gender.FEMALE,mother,father);

        tree.add(mother);
        tree.add(father);
        tree.add(child1);
        tree.add(child2);

        return tree;
    }
}
