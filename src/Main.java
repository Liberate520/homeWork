package homeWork.src;

import homeWork.src.member.FamilyMember;
import homeWork.src.tree.FamilyTree;
import homeWork.src.writer.FileHandler;
import member.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FamilyTree myTree = testTree();
        FamilyTree myTree = load();
        System.out.println(myTree);

//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/homeWork/src/writer/tree.txt";
//        fileHandler.save(myTree, filePath);
//        save(myTree);

    }

    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/homeWork/src/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/homeWork/src/writer/tree.txt";
        fileHandler.save(tree, filePath);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        FamilyMember member1 = new FamilyMember(
                "Nadezhda",
                "Petrova",
                "Alexandrovna",
                Gender.Female,
                LocalDate.of(1954, 2, 28));

        FamilyMember member2 = new FamilyMember(
                "Alexandr",
                "Petrov",
                "Sergeevich",
                Gender.Male,
                LocalDate.of(1956, 9, 1),
                LocalDate.of(2015, 2, 14));

        tree.add(member1);
        tree.add(member2);
        tree.setWedding(member1, member2);

        FamilyMember member3 = new FamilyMember(
                "Andrey",
                "Petrov",
                "Sergeevich",
                Gender.Male,
                LocalDate.of(1980, 3, 28),
                member2, member1);

        FamilyMember member4 = new FamilyMember(
                "Olga",
                "Petrova",
                "Sergeevna",
                Gender.Female,
                LocalDate.of(1989, 10, 16),
                member2, member1);

        tree.add(member3);
        tree.add(member4);

        FamilyMember member5 = new FamilyMember(
                "Larisa",
                "Vasilieva",
                "Petrovna",
                Gender.Female,
                LocalDate.of(1945, 9, 1));

        member5.addChild(member3);
        tree.add(member5);

        return tree;
    }
}
