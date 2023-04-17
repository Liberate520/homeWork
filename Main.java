package HW_5;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Human humanOne = new Human("Андрей", "Пивоваров", LocalDate.of(1974, 11, 21), Sex.male);
        // Human humanTwo = new Human("Мария", "Белова", LocalDate.of(1975, 6, 15), Sex.female);
        // Human humanThree = new Human("Артем", "Пивоваров", LocalDate.of(2000, 3, 8), Sex.male, humanTwo, humanOne);
        // Human humanFour = new Human("Кристина", "Вротмненоговна", LocalDate.of(2003, 1, 27), Sex.female);
        //Human humanFive = new Human("Алина", "Пивоварова", LocalDate.of(2023, 8, 18), Sex.female, humanFour, humanThree);
        FamilyTree test = new FamilyTree();
        Service service = new Service(test);

        service.addHuman("Андрей", "Пивоваров", LocalDate.of(1974, 11, 21), Sex.male);
        service.addHuman("Мария", "Белова", LocalDate.of(1975, 6, 15), Sex.female);
        service.addHuman("Артем", "Пивоваров", LocalDate.of(2000, 3, 8),
                Sex.male, service.getFamilyGroup().familyTree.get(0), service.getFamilyGroup().familyTree.get(1));
        service.addHuman("Кристина", "Вротмненоговна", LocalDate.of(2003, 1, 27), Sex.female);
        service.addHuman("Алина", "Пивоварова", LocalDate.of(2023, 8, 18),
                Sex.female, service.getFamilyGroup().familyTree.get(2),service.getFamilyGroup().familyTree.get(3));

        service.sortByLastName();
        for (Human item: test) {
            System.out.println(item);

        }
    }
}

