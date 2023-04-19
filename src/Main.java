import familyTree.FamilyTree;
import presenter.Presenter;
import service.Service;
import ui.Console;
import ui.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        human.Human humanOne = new human.Human("Иван", "Иванов", LocalDate.of(1994, 11, 21));
//        human.Human humanTwo = new human.Human("Анастасия", "Иванова", LocalDate.of(1995, 6, 15));
//        human.Human humanThree = new human.Human("Алия", "Иванова", LocalDate.of(2018, 3, 8), humanTwo.getId(), humanOne.getId());

        FamilyTree test = new FamilyTree();
//        test.add(humanOne);
//        test.add(humanTwo);
//        test.add(humanThree);
//        System.out.println(test);
//        test.parentsHuman(humanTwo);
//        test.childrensHuman(humanTwo);

//        Сохранение и чтение данных
//        familyTree.FamilyTree testTwo;
//        saveAndRead.SaveAndRead data = new saveAndRead.SaveAndRead();
//        String nameFile = "familyTree.FamilyTree.bin";
//        data.saveFile(test, nameFile);
//        testTwo = data.loadFile(nameFile);
////        System.out.println(testTwo);

        Service service = new Service(test);
//        service.addHuman("Иван", "Пирожков", LocalDate.of(1994, 11, 21));
//        service.addHuman("Анастасия", "Жалнина", LocalDate.of(1995, 6, 15));
//        service.addHuman("Маша", "Яковлева", LocalDate.of(1994, 6,16));
//        service.addHuman("Алия", "Александрова", LocalDate.of(2018, 3, 8));
//
//
//        service.sortByLastName();
//        System.out.println("Отсортированный список по фамилии: ");
//        for (Object item : test) {
//            System.out.println(item);
//        }
//        System.out.println();
//        service.sortByID();
//        System.out.println("Отсортированный список по ID: ");
//        for (Object item : test) {
//            System.out.println(item);
//        }

        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
