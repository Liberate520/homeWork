package HW;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) throws ClassNotFoundException {
        // FamilyTree<Human> familyTree = new FamilyTree();

        // Human andrey = new Human("Andrey", "Sergeevich", "1982", Gender.муж);
        // Human olga = new Human("Olga", "Olegovna", "1961", Gender.жен);
        // Human anny = new Human("Anny", "Sergeevna", "2003", null, Gender.жен,
        //         null, null, null);
        // Human anna = new Human("Anna", "Andreevna", "1980", "2020", Gender.жен,
        //         andrey, olga, anny);
        // familyTree.add(andrey);
        // familyTree.add(olga);
        // familyTree.add(anny);
        // familyTree.add(anna);

        FamilyTree<Pets> familyTree = new FamilyTree<>();
        Pets kat = new Pets("Муся", "2012", null);
        Pets dog = new Pets("Шарик", "2018", null);
        Pets parrot = new Pets("Попка", "2020", null);
      
        familyTree.add(kat);
        familyTree.add(dog);
        familyTree.add(parrot);

        for (Pets human : familyTree) {
            System.out.println(human);
        }

        System.out.println("\n Сортировка по имени");
        familyTree.sortByName();
        for (Pets human : familyTree) {
            System.out.println(human);
        }

        System.out.println("\n Сортировка по возрасту");
        familyTree.sortByAge();
        for (Pets human : familyTree) {
            System.out.println(human);
        }
        System.out.println("\n Сортировка по дате рождения");
        familyTree.sortByDataBirth();
        for (Pets human : familyTree) {
            System.out.println(human);
        }
        System.out.println("\n ");
        System.out.println(familyTree.getInfo());

        // IO save = new IO();
        // andrey.saveObj(save);
        // save.load("Family.txt");

    }
}