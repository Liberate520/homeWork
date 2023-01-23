public class Main {
    public static void main(String[] args) {

        Human father = new Human("Станислав", 1961, "male");
        Human mother = new Human("Василиса", 1985, "female");
        Human humanM1 = new Human("Вася", 1995, "male");
        Human humanF = new Human("Екатерина", 2000, "female");
        Human humanM2 = new Human("Вася", 1998, "male");
        Human human2 = new Human("Анна");

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

        Controller<Human> controller = new Controller<>(humanTree, "liveBeings.bin");
        controller.start();
    }
}