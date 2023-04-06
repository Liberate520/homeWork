import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Human humanOne = new Human("Иван", "Иванов", LocalDate.of(1994, 11, 21));
//        Human humanTwo = new Human("Анастасия", "Иванова", LocalDate.of(1995, 6, 15));
//        Human humanThree = new Human("Алия", "Иванова", LocalDate.of(2018, 3, 8), humanTwo.getId(), humanOne.getId());

        FamilyTree test = new FamilyTree();
//        test.add(humanOne);
//        test.add(humanTwo);
//        test.add(humanThree);
//        System.out.println(test);
//        test.parentsHuman(humanTwo);
//        test.childrensHuman(humanTwo);

//        Сохранение и чтение данных
//        FamilyTree testTwo;
//        SaveAndRead data = new SaveAndRead();
//        String nameFile = "FamilyTree.bin";
//        data.saveFile(test, nameFile);
//        testTwo = data.loadFile(nameFile);
////        System.out.println(testTwo);

        Service service = new Service(test);
        service.addHuman("Иван", "Пирожков", LocalDate.of(1994, 11, 21));
        service.addHuman("Анастасия", "Жалнина", LocalDate.of(1995, 6, 15));
        service.addHuman("Маша", "Яковлева", LocalDate.of(1994, 6,16));
        service.addHuman("Алия", "Александрова", LocalDate.of(2018, 3, 8));


        service.sortByLastName();
        System.out.println("Отсортированный список по фамилии: ");
        for (Human item : test) {
            System.out.println(item);
        }
        System.out.println();
        service.sortByID();
        System.out.println("Отсортированный список по ID: ");
        for (Human item : test) {
            System.out.println(item);
        }
    }
}
