import file_handler.FileHandler;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args){
        //FamilyTree tree = load();
        FamilyTree tree = testTree();
        System.out.println(tree);
        save(tree);

    }

    private static void save(FamilyTree tree){
        String filePath = "src/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree,filePath);
    }

    private static FamilyTree load(){
        String filePath = "src/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }



    static FamilyTree testTree(){
        FamilyTree familyTree = new FamilyTree();
        Human yulia = new Human("Юлия", Gender.Female,LocalDate.of(1971,4,12));
        Human kostya = new Human("Костя",Gender.Mail,LocalDate.of(1972,2,2));
        Human nikita = new Human("Никита",Gender.Mail,yulia,kostya,LocalDate.of(1991,7,3));
        Human gosha = new Human("Георгий",Gender.Mail,yulia,kostya,LocalDate.of(1992,12,4));
        Human vasilisa = new Human("Василиса",Gender.Female,null,nikita,LocalDate.of(2013,7,20));
        Human timofey= new Human("Тимофей",Gender.Mail,null,gosha,LocalDate.of(2016,6,3));
        yulia.addChildren(nikita);
        yulia.addChildren(gosha);
        kostya.addChildren(nikita);
        kostya.addChildren(gosha);
        nikita.addChildren(vasilisa);
        gosha.addChildren(timofey);

        familyTree.addHumanInTree(yulia);
        familyTree.addHumanInTree(kostya);
        familyTree.addHumanInTree(nikita);
        familyTree.addHumanInTree(gosha);
        familyTree.addHumanInTree(vasilisa);
        familyTree.addHumanInTree(timofey);


        return familyTree;




    }


}
