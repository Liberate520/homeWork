import familyTree.FamilyTree;
import human.*;
import java.time.LocalDate;
import static fileHandler.FileHandler.*;


public class Program {
    public static void main(String[] args) throws Exception {
//        FamilyTree tree = treeFamily();
//
//        treeSerialize(tree);
        FamilyTree tree = treeDeserialize();
        System.out.println(tree);
    }

    static FamilyTree treeFamily(){
        FamilyTree tree = new FamilyTree();

        Human grandMother1 = new Human("Huse", "Loura",
                LocalDate.of(1950,4,10) ,
                LocalDate.of(2012,6,20),Gender.FEMALE);

        Human grandFather1 = new Human("Huse", "Henry",
                LocalDate.of(1947,5,20),Gender.MALE);

        Human grandMother2 = new Human("Tomson", "Mary",
                LocalDate.of(1950,4,10),
                LocalDate.of(2012,6,20),Gender.FEMALE);

        Human grandFather2 = new Human("Tomson", "Harry",
                LocalDate.of(1947,5,20),Gender.MALE);

        tree.add(grandMother1);
        tree.add(grandFather1);
        tree.add(grandMother2);
        tree.add(grandFather2);

        Human mother = new Human("Brown","Hillary",
                LocalDate.of(1990,9,17),Gender.FEMALE,grandMother1,grandFather1);

        Human father = new Human("Brown","John",
                LocalDate.of(1986,11,17), Gender.MALE,grandMother2,grandFather2);

        Human child1 = new Human("Brown","Bob",
                LocalDate.of(2010,3,1),Gender.MALE,mother,father);

        Human child2 = new Human("Brown","Gretta",
                LocalDate.of(2011,11,4),Gender.FEMALE,mother,father);

        tree.add(mother);
        tree.add(father);
        tree.add(child1);
        tree.add(child2);

        return tree;
    }
}
