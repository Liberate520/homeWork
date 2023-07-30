import java.time.LocalDate;
import java.util.logging.FileHandler;

import Human.Gender;
import Human.Human;
import family_tree.FamilyTree;

public class Main {
   public static void main(String[] args) {
        // String path = "src/family_tree/FMyTree.out";
        // FileHandler fileHandler = new FileHandler();
        
        FamilyTree tree = makeTree();
        System.out.println(tree);

        tree.sortByAge();
        System.out.println(tree);

        tree.sortById();
        System.out.println(tree);

        tree.sortByName();
        System.out.println(tree);

        // fileHandler.save(tree, path);

        // FileHandler fileHandler = new FileHandler();
        // FamilyTree tree = (FamilyTree) fileHandler.read(path);
        // System.out.println(tree);
    }    
        
    static FamilyTree makeTree(){
        FamilyTree tree = new FamilyTree();

        Human roza = new Human("Захарова Роза Карповна", Gender.Male, LocalDate.of(1958,4,12));
        Human nikolay = new Human("Федотов Николай Петрович", Gender.Female, LocalDate.of(1953,1,17));

        tree.add(roza);
        tree.add(nikolay);

        nikolay.setSpouse(roza);
        roza.setSpouse(nikolay);

        Human marina = new Human("Федотова Марина Николаевна", Gender.Female, LocalDate.of(1975,9,1), roza, nikolay);
        tree.add(marina);

        // nikolay.addChild(marina);
        // roza.addChild(marina);
        // marina.addParent(nikolay);
        // marina.addParent(roza);
            
        Human sergey = new Human("Гаврилов Сергей Олегович", Gender.Male, LocalDate.of(1975,8,26));
        tree.add(sergey);

        tree.setWedding(sergey.getId(), marina.getId());
            
        Human arina = new Human("Гаврилова Арина Сергеевна", Gender.Female, LocalDate.of(1998,8,13));
        tree.add(arina);
            
        sergey.addChild(arina);
        marina.addChild(arina);
        arina.addParent(sergey);
        arina.addParent(marina);

        Human polina = new Human("Гаврилова Полина Сергеевна", Gender.Female, LocalDate.of(2004,11,9));
        tree.add(polina);

        sergey.addChild(polina);
        marina.addChild(polina);
        polina.addParent(sergey);
        polina.addParent(marina);

        return tree;
    }
}


