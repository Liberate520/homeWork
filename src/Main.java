import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    LocalDate date =LocalDate.now();


        Human person0 = new Human("Николай", "Калугин", LocalDate.of(1938,03,01), LocalDate.of(2015, 8,22), Gender.MALE, null, null,null,null,null,null);
        Human person1 = new Human("Зинаида", "Калугина", LocalDate.of(1943, 10,15), null, Gender.FEMALE, null,null,null,null,null,null );
        Human person2 = new Human("Анатолий", "Кондратьев", LocalDate.of(1939, 11,14), LocalDate.of(2018, 11, 10), Gender.MALE, null,null,null,null,null,null );
        Human person3 = new Human("Александра", "Кондратьева", LocalDate.of(1938, 4,26), LocalDate.of(1994, 1, 5), Gender.FEMALE, null,null,null,null,null,null );
        Human person4 = new Human("Олег", "Кондратьев", LocalDate.of(1965, 4,12), null, Gender.MALE, null,null,null,null,null,null );
        Human person5 = new Human("Татьяна", "Кондратьева", LocalDate.of(1964, 3,11), null, Gender.FEMALE, null,null,null,null,null,null );
        Human person6 = new Human("Татьяна", "Кондратьева", LocalDate.of(1974, 9,19), null, Gender.FEMALE, null,null,null,null,null,null );
        Human person7 = new Human("Алксандр", "Кондратьев", LocalDate.of(1984, 3,22), null, Gender.MALE, null,null,null,null,null,null );
        Human person8 = new Human("Анна", "Кондратьева", LocalDate.of(1986, 6,30), null, Gender.FEMALE, null,null,null,null,null,null );
        Human person9 = new Human("Иван", "Кондратьев", LocalDate.of(1994, 6,21), null, Gender.MALE, null,null,null,null,null,null );
        Human person10 = new Human("Денис", "Кондратьев", LocalDate.of(2004, 1,29), null, Gender.MALE, null,null,null,null,null,null );
        Human person11 = new Human("Дарья", "Кондратьева", LocalDate.of(1993, 3,23), null, Gender.FEMALE, null,null,null,null,null,null );
        Human person12 = new Human("Лев", "Кондратьев", LocalDate.of(2022, 6,11), null, Gender.MALE, null,null,null,null,null,null );


    FamilyTree familyTree = new FamilyTree();
    familyTree.addHuman(person0);
    familyTree.addHuman(person1);
    familyTree.addHuman(person2);
    familyTree.addHuman(person3);
    familyTree.addHuman(person4);
    familyTree.addHuman(person5);
    familyTree.addHuman(person6);
    familyTree.addHuman(person7);
    familyTree.addHuman(person8);
    familyTree.addHuman(person9);
    familyTree.addHuman(person10);
    familyTree.addHuman(person11);
    familyTree.addHuman(person12);


        System.out.println(familyTree.getHumanList());
        System.out.println("-----------------------");

    }
}
