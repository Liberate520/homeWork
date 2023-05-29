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

        person12.setFather(person9.getName());
        person12.setMother(person11.getName());

        person10.setFather(person4.getName());
        person10.setMother(person6.getName());
        person10.setBrother(person9.getName());
        person10.setBrother(person7.getName());
        person10.setSister(person8.getName());
        person10.setGrandFather(person2.getName());
        person10.setGrandFather(person0.getName());
        person10.setGrandMother(person3.getName());
        person10.setGrandMother(person1.getName());

        person9.setFather(person4.getName());
        person9.setMother(person6.getName());
        person9.setBrother(person10.getName());
        person9.setBrother(person7.getName());
        person9.setSister(person8.getName());
        person9.setGrandFather(person2.getName());
        person9.setGrandFather(person0.getName());
        person9.setGrandMother(person3.getName());
        person9.setGrandMother(person1.getName());

        person8.setFather(person4.getName());
        person8.setMother(person5.getName());
        person8.setBrother(person10.getName());
        person8.setBrother(person7.getName());
        person8.setBrother(person9.getName());
        person8.setGrandFather(person2.getName());
        person8.setGrandMother(person3.getName());

        person7.setFather(person4.getName());
        person7.setMother(person5.getName());
        person7.setBrother(person10.getName());
        person7.setSister(person8.getName());
        person7.setBrother(person9.getName());
        person7.setGrandFather(person2.getName());
        person7.setGrandMother(person3.getName());

        person6.setFather(person0.getName());
        person6.setMother(person1.getName());

        person4.setFather(person2.getName());
        person4.setMother(person3.getName());

        System.out.println(familyTree.getHumanList());
        System.out.println("-----------------------");
        System.out.println(person0.getName() + person0.getAge(person0.getBirthdate(),person0.getDeathDate()));
        System.out.println("-----------------------");
        System.out.println(person1.getName() + person1.getAge(person1.getBirthdate(), person1.getDeathDate()));
        System.out.println("-----------------------");
        System.out.println(person12.getFather());
        System.out.println(person12.getMother());
        System.out.println(person9.getBrother());
        System.out.println(person6.getMother());
    }
}
