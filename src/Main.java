import Classes.FamilyTree;
import Classes.FileGuide;
import Classes.Human;
import Classes.TestInput;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;

import static Classes.Gender.female;
import static Classes.Gender.male;

public class Main {


    public static void main(String[] args) throws IOException {
        String pathToTreeFile ="src/tree.out";
        FileGuide fileGuide =new FileGuide();
        FamilyTree tree =new FamilyTree();
         TestInput.TestInput(tree);//Тестовый вариант заполнения списка
        System.out.println(tree.humanList.size());
        System.out.println(tree.getInfo());
        fileGuide.save(tree, pathToTreeFile);

//        FileGuide fileGuide =new FileGuide();
////        FamilyTree tree=new FamilyTree(); tree= (FamilyTree) fileGuide.read(pathToTreeFile);//Тоже работает
//        FamilyTree tree = (FamilyTree) fileGuide.read(pathToTreeFile);
//        System.out.println(tree.humanList.size());
//        System.out.println(tree.getInfo());
//    //    Human human = tree.humanList.get();
//        System.out.println(tree.humanList.get(2));

    }



}
