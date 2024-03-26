import Tree.Gender;
import Tree.Person;
import Tree.FamilyTree;
import writer.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {
        FamilyTree tree=upLoadTree();
        //FamilyTree tree=createTree();

        System.out.println(tree);
        //saveTree(tree);

    }



    static FamilyTree createTree() {
        FamilyTree tree=new FamilyTree();


        int id = 0;// ID будет выступать автоинкрементом

        Person maria = new Person(id++, "Мария Трофимовна Т.",
                Gender.female,
                LocalDate.of(1931, 1, 19),
                LocalDate.of(2021, 1, 15),
                null,
                null);

        Person vladimir = new Person(id++, "Владимир Николаевич Т.",
                Gender.male,
                LocalDate.of(1931, 05, 12),
                LocalDate.of(1979, 3, 13),
                null,
                null);

        Person sergey = new Person(id++, "Сергей Владимирович Т.",
                Gender.male,
                LocalDate.of(1956, 11, 14),
                LocalDate.of(2023, 12, 16),
                maria,
                vladimir);

        Person ludmila = new Person(id++, "Людмила Алексеевна Т.",
                Gender.female,
                LocalDate.of(1956, 7, 5),
                null,
                null,
                null);

        Person alexandr = new Person(id++, "Александр Сергеевич Т.",
                Gender.male,
                LocalDate.of(1989, 1, 14),
                null,
                ludmila,
                sergey);


        tree.add(maria);
        tree.add(vladimir);
        tree.add(sergey);
        tree.add(ludmila);
        tree.add(alexandr);
        return tree;

    }

    private static void saveTree(FamilyTree tree){
        String filePath="src/writer/familyTree.txt";
        FileHandler fileHandler=new FileHandler();
        fileHandler.saveToFile(tree,filePath);

    }

    private static FamilyTree upLoadTree() {
        String filePath="src/writer/familyTree.txt";
        FileHandler fileHandler=new FileHandler();
        return fileHandler.uploadFromFile(filePath);
    }







}
