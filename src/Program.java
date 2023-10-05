import familyTree.FamilyTree;
import fileHandler.FileHandler;
import obj.Gender;
import obj.dog.Dog;
import obj.human.Human;

import java.time.LocalDate;


public class Program {
    public static void main(String[] args){
//        FamilyTree tree = treeFamily();
//        System.out.println(tree);
//        String filePath = "tree.txt";
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(tree, filePath);
//        FamilyTree tree = (FamilyTree) fileHandler.read(filePath);
//        System.out.println(tree);
        FamilyTree tree = treeFamily();
        FamilyTree treedog = treeFamilyDog();

        System.out.println("Люди: Сортировка по Возрасту");
        tree.sortByAge();
        System.out.println(tree);

        System.out.println("Собаки: СFamilyTree tree = treeFamily();ортировка по Возрасту");
        treedog.sortByAge();
        System.out.println(treedog);

//        System.out.println("Сортировка по Возрасту");
//        tree.sortByAge();
//        System.out.println(tree);
//
//        System.out.println("Сортировка по Имени");
//        tree.sortByLastName();
//        System.out.println(tree);
//
//        System.out.println("Сортировка по Дате Рождения");
//        tree.sortByBornDate();
//        System.out.println(tree);
    }
    public static FamilyTree treeFamily(){
        FamilyTree tree = new FamilyTree();

        Human grandMother1 = new Human("Huse", "Loura",
                LocalDate.of(1950, 04,10) ,
                LocalDate.of(2012,06,20),Gender.FEMALE);

        Human grandFather1 = new Human("Huse", "Henry",
                LocalDate.of(1947,05,20), Gender.MALE);

        Human grandMother2 = new Human("Tomson", "Mary",
                LocalDate.of(1945,04,16),
                LocalDate.of(2012,06,20),Gender.FEMALE);

        Human grandFather2 = new Human("Tomson", "Harry",
                LocalDate.of(1949,11,13),Gender.MALE);

        tree.add(grandMother1);
        tree.add(grandFather1);
        tree.add(grandMother2);
        tree.add(grandFather2);

        Human mother = new Human("Brown","Hillary",
                LocalDate.of(1990,02,17),Gender.FEMALE,grandMother1,grandFather1);

        Human father = new Human("Brown","John",
                LocalDate.of(1986,11,17), Gender.MALE,grandMother2,grandFather2);

        Human child1 = new Human("Brown","Bob",
                LocalDate.of(2010,03,1),Gender.MALE,mother,father);

        Human child2 = new Human("Brown","Gretta",
                LocalDate.of(2011,11,4),Gender.FEMALE,mother,father);

        tree.add(mother);
        tree.add(father);
        tree.add(child1);
        tree.add(child2);

        return tree;
    }

    public static FamilyTree treeFamilyDog(){
        FamilyTree tree = new FamilyTree();

        Human grandMother1 = new Human("Huse", "Loura",
                LocalDate.of(1950, 04,10) ,
                LocalDate.of(2012,06,20),Gender.FEMALE);

// Human human, String fstName,String lstName,
// Gender gender, LocalDate bornDate, LocalDate deathDate

        Dog mother = new Dog(grandMother1,"Lima","John-Fon-Derby",Gender.FEMALE,LocalDate.of(2002,10,10)
                ,LocalDate.of(2010,9,5));

        Dog father = new Dog(grandMother1,"Dexter","Brown-Fon-Chess",Gender.MALE,LocalDate.of(2004,4,14));

        tree.add(mother);
        tree.add(father);

        Dog puppy1 = new Dog(grandMother1,"Bobby",Gender.MALE,LocalDate.of(2008,9,5));
        Dog puppy2 = new Dog(grandMother1,"Busia",Gender.FEMALE,LocalDate.of(2009,7,17));

        tree.add(puppy1);
        tree.add(puppy2);

        return tree;
    }
}
