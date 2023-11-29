package family_tree;

import family_tree.family.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Дерево до сохранения в файл:\n");
        System.out.println(testTree());

        save(testTree());

        System.out.println("Дерево после выгрузки в из файла:\n");
        FamilyTree savedTree = download();
        System.out.println(savedTree);

    }

    private static void save(FamilyTree tree) {
        String filePath = "src/writer/tree";
        FileHandler fh = new FileHandler();
        System.out.printf("Данные успешно сохранены в файл? %b\n", fh.write(tree, filePath));
    }

    private static FamilyTree download() {
        String filePath = "src/writer/tree";
        FileHandler fh = new FileHandler();
        return (FamilyTree) fh.read(filePath);
    }

    static FamilyTree testTree(){

        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human(Gender.Male,"Ivan","Ivanov");
        Human human2 = new Human(Gender.Female,"Maria","Ivanova");
        familyTree.addFamilyMember(human1);
        familyTree.addFamilyMember(human2);
        familyTree.setWedding(human1, human2);

        Human human3 = new Human(Gender.Male, "Peter", "Petrov");
        Human human4 = new Human(Gender.Female, "Elena", "Petrova");
        familyTree.addFamilyMember(human3);
        familyTree.addFamilyMember(human4);
        familyTree.setWedding(human3, human4);

        Human human5 = new Human(Gender.Male,"Ivanushka","Ivanov");
        Human human6 = new Human(Gender.Female,"Alenushka","Petrova");

        human5.setFather(human1);
        human5.setMother(human2);
        human6.setFather(human3);
        human6.setMother(human4);

        familyTree.addFamilyMember(human5);
        familyTree.addFamilyMember(human6);
        familyTree.setWedding(human5, human6);

        human1.setBirthDate(LocalDate.of(1921,1,1));
        human2.setBirthDate(LocalDate.of(1922,2,2));
        human3.setBirthDate(LocalDate.of(1923,3,3));
        human4.setBirthDate(LocalDate.of(1924,4,4));
        human5.setBirthDate(LocalDate.of(1945,5,5));
        human6.setBirthDate(LocalDate.of(1946,6,6));

        Human grandMother = new Human(Gender.Female,"Varvara", "Ivanova",LocalDate.of(1900,1,1));
        grandMother.addChild(human1);
        grandMother.setDeathDate(LocalDate.of(2000,1,1));
        familyTree.addFamilyMember(grandMother);

        return familyTree;
    }
}