import human.Gender;
import human.Human;
import tree.FamilyTree;
import writer.FileHandler;
import writer.Writable;

import java.time.LocalDate;

public class Test {
    public void Main(){
    }
    public static void main(String[] args) {
        /**
         * загрузка из файла
         */
        FamilyTree< Human > myTree = new FamilyTree<>();
//        FamilyTree<Human> myTree = load();

        Human human1 = new Human(1, "Кузнецов", "Владислав", LocalDate.of(1983, 5, 1), Gender.Male);
        Human human2 = new Human(2, "Березянская", "Ольга", LocalDate.of(1989, 2, 20), Gender.Female);
        Human human3 = new Human(3, "Кузнецов", "Юрий", LocalDate.of(1944, 7, 4), Gender.Male);
        Human human4 = new Human(4, "Афонченко", "Людмила", LocalDate.of(1948, 8, 23), Gender.Female);
        Human human5 = new Human(5, "Березянский", "Игорь", LocalDate.of(1960, 5, 26), Gender.Male);
        Human human6 = new Human(6, "Березянская", "Наталья", LocalDate.of(1964, 5, 28), Gender.Female);
        Human human7 = new Human(7, "Афонченко", "Федор", LocalDate.of(1921, 02, 23), Gender.Male);
        Human human8 = new Human(8, "Ильченко", "Талия", LocalDate.of(1924, 4, 1), Gender.Female);
        Human human9 = new Human(9, "Афонченко", "Ирина", LocalDate.of(1959, 9, 2), Gender.Female);
        Human human10 = new Human(10, "Кузнецова", "Ирина", LocalDate.of(2014, 3, 26), Gender.Female);
        Human human11 = new Human(11, "Кушнарева", "Людмила", LocalDate.of(1933, 2, 15), Gender.Female);
        myTree.addHuman(human1);
        myTree.addHuman(human2);
        myTree.addHuman(human3);
        myTree.addHuman(human4);
        myTree.addHuman(human5);
        myTree.addHuman(human6);
        myTree.addHuman(human7);
        myTree.addHuman(human8);
        myTree.addHuman(human9);
        myTree.addHuman(human10);
        myTree.addHuman(human11);

        human1.setSpouse(human2);
        human3.setSpouse(human4);
        human5.setSpouse(human6);
        human7.setSpouse(human8);

        human1.setChild(human10);
        human2.setChild(human10);
        human3.setChild(human1);
        human4.setChild(human1);
        human5.setChild(human2);
        human6.setChild(human2);
        human7.setChild(human9);
        human8.setChild(human9);
        human7.setChild(human4);
        human8.setChild(human4);
        human11.setChild(human6);

        human4.setDayOfDeath(LocalDate.of(2019, 9, 24));
        human5.setDayOfDeath(LocalDate.of(2011, 2, 10));
        human7.setDayOfDeath(LocalDate.of(2005, 12, 25));
        human8.setDayOfDeath(LocalDate.of(2012, 5, 7));
        /**
         * сохранение в файл
         */
        save(myTree);

        /**
         * Вывод всех членов семьи
         */
        System.out.println("-".repeat(128));
        System.out.println(myTree.allTree());
        System.out.println("*".repeat(128));


        myTree.sortByName();
        System.out.println(myTree);
        myTree.sortByAge();
        System.out.println(myTree);
        myTree.sortByLastname();
        System.out.println(myTree);


        /**
         * Поиск по слову (имени)
         */
        String str = myTree.SearchByNameSurname("Ирина");
        System.out.println(str);
        System.out.println("\n");

        /**
         * Поиск по слову (фамилии)
         */
        String str1 = myTree.SearchByNameSurname("Афонченко");
        System.out.println(str1);
        System.out.println("\n");

    }

    private static FamilyTree<Human> load() {
        Writable fileHandler = new FileHandler();
        String filePath = "src/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }
    private static void save(FamilyTree<Human> myTree){
        Writable fileHandler = new FileHandler();
        String filePath = "src/writer/tree.txt";
        boolean saved = fileHandler.save(myTree, filePath);
        System.out.println("Сохранение файла: " + saved);
    }


}
