import java.io.Serializable;

public class Main {
    public static void main(String[] args) {

        Human father = new Human("Станислав", 1961, "male");
        Human mother = new Human("Василиса", 1985, "female");
        Human humanM1 = new Human("Вася", 1995, "male");
        Human humanF = new Human("Екатерина", 2000, "female");
        Human humanM2 = new Human("Вася", 1998, "male");
        Human human2 = new Human("Анна");

        System.out.println("Вывод humanов напрамую:");
        System.out.println(father);
        System.out.println(mother);
        System.out.println(humanM1);
        System.out.println(humanM2);
        System.out.println(humanF);
        System.out.println(human2);

        FamilyTree<Human> humanTree = new FamilyTree<>();
        humanTree.addLiveBeing(new Human("Владимир", 1980, "male"), father, null);
        humanTree.addLiveBeing(father, null, null);
        humanTree.addLiveBeing(humanM1, father, mother);
        humanTree.addLiveBeing(humanM2, father, mother);
        humanTree.addLiveBeing(human2, humanM1, humanF);
        humanTree.addLiveBeing(new Human("Анастасия"), null, human2);
        System.out.println();

        Alifant alifantFather = new Alifant("Зигмунд", 1975, "male");
        Alifant alifantMother = new Alifant("Аделина", 1970, "female");
        Alifant alifantSon = new Alifant("Хоботок", 1998, "male");
        Alifant alifantDaughter = new Alifant("Мамба", 1991, "female");

        FamilyTree<Alifant> alifantTree = new FamilyTree<>();
        alifantTree.addLiveBeing(alifantFather, null, null);
        alifantTree.addLiveBeing(alifantMother, null, null);
        alifantTree.addLiveBeing(alifantSon, alifantFather, alifantMother);
        alifantTree.addLiveBeing(alifantDaughter, alifantFather, alifantMother);

        System.out.println("Вывод humanов через FamilyTree:");
        System.out.println("Поиск humanа по имени:");
        System.out.println(humanTree.findByName("Анна"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с одним именем:");
        System.out.println(humanTree.findAllByName("Вася"));
        System.out.println();

        System.out.println("Вывод humanов через FamilyTree с помощью метода showAllToConsole");
        humanTree.showAllInConsole();
        System.out.println();

        InputOutputBin inputOutputBin = new InputOutputBin();

        System.out.println("INPUT/OUTPUT HUMAN:");
        inputOutputBin.saveAs(humanF, "human.bin");
        System.out.println(inputOutputBin.readFrom("human.bin"));
        System.out.println();

        System.out.println("INPUT/OUTPUT HUMAN TREE:");
        inputOutputBin.saveAs(humanTree, "humansList.bin");
        Serializable restore = inputOutputBin.readFrom("humansList.bin");
        FamilyTree<Human> restoreHumanFamilyTree = (FamilyTree) restore;
        System.out.println(restoreHumanFamilyTree.getLiveBeings());
        System.out.println();

        System.out.println("Вывод списка Humanов циклом forech:");
        for (Human human : humanTree) {
            System.out.println(human);
        }
        System.out.println();

        System.out.println("Вывод отсортированных по имени Humanов:");
        humanTree.sortByName();
        for (Human human : humanTree) {
            System.out.println(human);
        }
        System.out.println();

        System.out.println("Вывод Alifantов через FamilyTree с помощью метода showAllToConsole:");
        alifantTree.showAllInConsole();

        System.out.println("Вывод отсортированных по дате рождения Alifantов:");
        alifantTree.sortByDate();
        for (Alifant alifant : alifantTree) {
            System.out.println(alifant);
        }
        System.out.println();

        System.out.println("Вывод отсортированных по имени Alifantов:");
        alifantTree.sortByName();
        for (Alifant alifant : alifantTree) {
            System.out.println(alifant);
        }
        System.out.println();

        System.out.println("Поиск Alifantов по имени:");
        System.out.println(alifantTree.findByName("Хоботок"));
        System.out.println();

        FamilyTreeView<Human> view = new FamilyTreeView<>(humanTree);
        view.view();
    }
}
