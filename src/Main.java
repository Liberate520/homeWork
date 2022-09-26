import HR.Gender;
import HR.Human;
import SaverLoader.fileHandler;
import familyTree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = upTree();
//        FamilyTree tree = load();
        System.out.println(tree);
//        save(tree);
    }

    private static FamilyTree load() {
        String filePath = "src/FamilyTree/writer/tree.out";
        fileHandler fileHandler = new fileHandler();
        return (FamilyTree) fileHandler.load(filePath);
    }

    private static void save(FamilyTree tree) {
        String filePath = "src/FamilyTree/writer/tree.out";
        fileHandler fileHandler = new fileHandler();
        if (fileHandler.save(tree, filePath)) {
            System.out.println("каталог сохранён");
        }
        else {
            System.out.println("проверьте параметры сохранения");
        }
    }

    static FamilyTree upTree(){
        FamilyTree tree = new FamilyTree();

        Human andrey = null;
        Human polina = new Human("Полина", Gender.Female,"Astana", LocalDate.of(1997, 6, 7));
        tree.add(polina);

        Human viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967, 4, 9), null, polina);
        Human vika = new Human("Виктория", Gender.Female, LocalDate.of(1969, 9, 7));
        tree.add(viktor);
        tree.add(vika);

        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1990, 2, 14), viktor, vika);
        tree.add(olga);
        Human igor = new Human("Игорь", Gender.Male, "Petersburg", LocalDate.of(2018, 8, 14),  andrey, olga);
        tree.add(igor);


        return tree;
    }
}
