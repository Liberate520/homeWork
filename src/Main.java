import my_family_tree.human.Gender;
import my_family_tree.human.Human;
import my_family_tree.service.Service;
import my_family_tree.tree.FamilyTree;
import my_family_tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        familyTree tree = load();
//        familyTree tree = new familyTree();
        Service service = new Service();

        Human katya = service.addHumanToTheFamily("Екатерина", Gender.Female, LocalDate.of(1986, 8, 16));
        Human kolya = service.addHumanToTheFamily("Николай", Gender.Male, LocalDate.of(1984, 5, 9));
        Human asya = service.addHumanToTheFamily("Ася", Gender.Female, LocalDate.of(1962, 4, 21));
        asya.addChildren(katya);
        katya.addParents(asya);

        Human sasha = service.addHumanToTheFamily("Александр", Gender.Male, LocalDate.of(2007, 1, 30));
        sasha.addParents(katya);
        sasha.addParents(kolya);

        Human anya = service.addHumanToTheFamily("Анна", Gender.Female, LocalDate.of(2010, 3, 7));
        sasha.addParents(katya);
        sasha.addParents(kolya);


        System.out.println(service);
        service.sortByName();
        System.out.println(service);
        service.sortByAge();
        System.out.println(service);
        service.sortByYear();
        System.out.println(service);
//        System.out.println(tree.findSiblings(3));

//        save(tree);


    }

    private static void save(FamilyTree tree){
        String filePath = "src/my_family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    private static FamilyTree load(){
        String filePath = "src/my_family_tree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
        return tree;

    }
}
