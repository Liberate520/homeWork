import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Human human1 = new Human("O-647", LocalDate.of(2078,4,12), Gender.MALE);
        Human human2 = new Human("I-693", LocalDate.of(2079,6,17), Gender.FEMALE);
        Human human3 = new Human("K-953", LocalDate.of(2101,1,4), Gender.MALE, human1, human2);
        Human human4 = new Human("P-328", LocalDate.of(2101,1,4), Gender.FEMALE, human1, human2);
        Human human5 = new Human("L-493", LocalDate.of(2104,7,19), Gender.MALE, human1, human2);
        Human human6 = new Human("M-727", LocalDate.of(2134,11,6), Gender.FEMALE, human4, human5);
        Human human7 = new Human("U-952", LocalDate.of(2134,2,17), Gender.FEMALE, human4, human5);

        human1.addChild(human3);
        human1.addChild(human4);
        human1.addChild(human5);
        human2.addChild(human3);
        human2.addChild(human3);///children doubling check

        human2.addChild(human4);
        human2.addChild(human5);
        human4.addChild(human6);
        human4.addChild(human7);
        human5.addChild(human6);
        human5.addChild(human7);

        FamilyTree<Human> familyTree = new FamilyTree<>();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        Dog dog1 = new Dog("dog1", LocalDate.of(2078,4,12), Gender.MALE);
        Dog dog2 = new Dog("dog2", LocalDate.of(2079,6,17), Gender.FEMALE);
        Dog dog3 = new Dog("dog3", LocalDate.of(2101,1,4), Gender.MALE);
        FamilyTree<Dog> dogFamilyTree = new FamilyTree<>();
        dogFamilyTree.addHuman(dog1);
        dogFamilyTree.addHuman(dog2);
        dogFamilyTree.addHuman(dog3);

        System.out.println("--------Исходный список людей--------------");
        System.out.println(familyTree.printHumanList());
        System.out.println("--------Исходный список собак--------------");
        System.out.println(dogFamilyTree.printHumanList());

        System.out.println("-------------------");

        List<Human> brothersList1 =  familyTree.findBrothers(human5);
        System.out.println(brothersList1);



        // блок для сохранения
        //Savable savableSaver = new FileHandler();
        //savableSaver.save(familyTree, "familyTreeOne");

        //блок для чтения файла
        //Savable savableLoader = new FileHandler();
        //FamilyTree familyTreeRestored = (FamilyTree) savableLoader.load("familyTreeOne");
        //System.out.println(familyTreeRestored.printHumanList());

        System.out.println();
        System.out.println("---------------вывод людей через итератор---------------");
        for(Human human : familyTree){
            System.out.println(human);
        }

        familyTree.sortByName();
        System.out.println();
        System.out.println("---------------сортировка людей по имени---------------");
        for(Human human : familyTree){
            System.out.println(human);
        }

        familyTree.sortByBirthDate();
        System.out.println();
        System.out.println("---------------сортировка людей по дате рождения---------------");
        for(Human human : familyTree){
            System.out.println(human);
        }



    }


}
