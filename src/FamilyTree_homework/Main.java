package FamilyTree_homework;
import FamilyTree_homework.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = load();
        //FamilyTree tree = testTree();
        System.out.println(tree);
    }
    private static FamilyTree load(){
        String filePath = "C:\\Users\\tiliv\\IdeaProjects\\homeWork\\src\\FamilyTree_homework";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }
    private static void save(FamilyTree tree){
        String filePath = "C:\\Users\\tiliv\\IdeaProjects\\homeWork\\src\\FamilyTree_homework";
        FileHandler fileHandler = new FileHandler();
        if(fileHandler.save(tree, filePath)){
            System.out.println();
        }
    }
    static FamilyTree testTree() throws IOException {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya, masha);
        tree.add(christina);
        tree.add(semyon);
        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);
        tree.add(grandMother);
        tree.saveToFile("Tree1.out");

        return tree;

    }

}
