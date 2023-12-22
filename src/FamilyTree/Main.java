package FamilyTree;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Gender;
import FamilyTree.model.HR.Human;
import FamilyTree.model.Saver.FileHandler;
import FamilyTree.model.FT.commonParam;

import java.io.Serializable;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FamTree tree = load();
//        FamTree tree = updTree();
        System.out.println(tree);
//        save(tree);
    }

    private static FamTree load() {
        String savePath = "src/FamilyTree/model/saver/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamTree) fileHandler.load(savePath);
    }

    private static void save(FamTree tree) {
        String savePath = "src/FamilyTree/model/saver/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, savePath);
        if (fileHandler.save((Serializable) tree, savePath)) {
            System.out.println("каталог сохранён");
        }
        else {
            System.out.println("проверьте параметры сохранения");
        }
    }
    static FamTree updTree(){
        FamTree tree = new FamTree();

        Human andrey = null;
        Human polina = new Human("Полина", Gender.Female,"Astana", LocalDate.of(1936, 9, 7), LocalDate.of(1997, 5, 7),null, null );
        tree.add((commonParam) polina);

        Human viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967, 4, 9), null, polina);
        Human alina = new Human("Алина", Gender.Female, LocalDate.of(1969, 9, 7));
        tree.add((commonParam) viktor);
        tree.add((commonParam) alina);

        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1992, 2, 14), viktor, alina);
        tree.add((commonParam) olga);
        Human igor = new Human("Игорь", Gender.Male, "Petersburg", LocalDate.of(2018, 8, 14),  andrey, olga);
        tree.add((commonParam) igor);

        return tree;
    }

}
