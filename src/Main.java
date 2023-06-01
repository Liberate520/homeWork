import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    LocalDate date =LocalDate.now();


        Human person0 = new Human("Николай Калугин", LocalDate.of(1938,03,01), LocalDate.of(2015, 8,22), Gender.MALE, null, null);
        Human person1 = new Human("Зинаида Калугина", LocalDate.of(1943, 10,15), null, Gender.FEMALE, null, null);
        Human person2 = new Human("Анатолий Кондратьев", LocalDate.of(1939, 11,14), LocalDate.of(2018, 11, 10), Gender.MALE, null,null);
        Human person3 = new Human("Александра Кондратьева", LocalDate.of(1938, 4,26), LocalDate.of(1994, 1, 5), Gender.FEMALE, null,null);
        Human person4 = new Human("Олег Кондратьев", LocalDate.of(1965, 4,12), null, Gender.MALE, person2,person3);
        Human person5 = new Human("Татьяна Кондратьева", LocalDate.of(1964, 3,11), null, Gender.FEMALE, null,null);
        Human person6 = new Human("Таня Кондратьева", LocalDate.of(1974, 9,19), null, Gender.FEMALE, person0,person1);
        Human person7 = new Human("Алксандр Кондратьев", LocalDate.of(1984, 3,22), null, Gender.MALE, person4,person5);
        Human person8 = new Human("Анна Кондратьева", LocalDate.of(1986, 6,30), null, Gender.FEMALE, person4,person5);
        Human person9 = new Human("Иван Кондратьев", LocalDate.of(1994, 6,21), null, Gender.MALE, person4,person6);
        Human person10 = new Human("Денис Кондратьев", LocalDate.of(2004, 1,29), null, Gender.MALE, person4,person6);
        Human person11 = new Human("Дарья Кондратьева", LocalDate.of(1993, 3,23), null, Gender.FEMALE, null,null);
        Human person12 = new Human("Лев Кондратьев", LocalDate.of(2022, 6,11), null, Gender.MALE, person9,person11);


    FamilyTree familyTree = new FamilyTree();
    familyTree.add(person0);
    familyTree.add(person1);
    familyTree.add(person2);
    familyTree.add(person3);
    familyTree.add(person4);
    familyTree.add(person5);
    familyTree.add(person6);
    familyTree.add(person7);
    familyTree.add(person8);
    familyTree.add(person9);
    familyTree.add(person10);
    familyTree.add(person11);
    familyTree.add(person12);

    person7.addSister(person8);
    person9.addSister(person8);
    person10.addSister(person8);
    person8.addBrother(person7);
    person8.addBrother(person9);
    person8.addBrother(person10);
    person7.addBrother(person9);
    person7.addBrother(person10);
    person9.addBrother(person7);
    person9.addBrother(person10);
    person10.addBrother(person7);
    person10.addBrother(person9);

    FileHandler fileHandler = new FileHandler();
    fileHandler.save("/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/savedTree.txt", familyTree);
    Serializable loadObj = fileHandler.load("/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/savedTree.txt", "FamilyTree");

        System.out.println(familyTree.getInfo());
    }
}
