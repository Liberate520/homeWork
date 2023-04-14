public class Main {
    public static void main(String[] args) {
        Human person1 = new Human("Василий", "Лежебокин", 32, Sex.Male);
        person1.setFather("Анатолий", "Лежебоков", 57);
        person1.setMother("Анна", "Лежебокова", 53);
        person1.addBrotherOrSister("Мария", "Лежебокова", 25, Sex.Female);
        person1.addBrotherOrSister("Роман", "Лежебоков", 29, Sex.Male);
        System.out.println(person1);
    }
}
