
import presenter.Presenter;
import service.Service;
import ui.*;


public class Main {
    public static void main(String[] args) {
        View viewMainMenu = new ConsoleMainMenu();
        View viewWorkMenu = new ConsoleWorkMenu();
        Service service = new Service();
        new Presenter(viewMainMenu, service);
        new Presenter(viewWorkMenu,service);

        viewMainMenu.start();
    }
//
//        Service familyIvanov = new Service();
//
//        familyIvanov.readFamilyTreeFromFile ("Ivanov.txt");
//        if (familyIvanov.getInfo() == null) {
//            familyIvanov.addHuman("Иван", "Иванов", "25.10.1990", Gender.Male,
//                    null, null);
//            familyIvanov.addHuman("Светлана", "Светлова", "14.05.1993", Gender.Female,
//                    null, null);
//            familyIvanov.addHuman("Екатерина", "Иванова", "05.03.2012", Gender.Female,
//                    familyIvanov.getHumanById(1),
//                    familyIvanov.getHumanById(0));
//            familyIvanov.addHuman("Петр", "Иванов", "10.08.2015", Gender.Male,
//                    familyIvanov.getHuman("Светлана", "Светлова", "14.05.1993"),
//                    familyIvanov.getHuman("Иван", "Иванов", "25.10.1990"));
//            familyIvanov.addHuman("Михаил", "Иванов", "18.12.2017", Gender.Male,
//                    familyIvanov.getHuman("Светлана", "Светлова", "14.05.1993"),
//                    familyIvanov.getHuman("Иван", "Иванов", "25.10.1990"));
//            familyIvanov.addHuman("Сидр", "Светлов", "25.02.1970", Gender.Male, null, null);
//            familyIvanov.setFather(familyIvanov.getHumanById(5), familyIvanov.getHumanById(1));
//        }
//
//
//        System.out.println(familyIvanov.getInfo());
//        familyIvanov.sortByFirstName();
//        System.out.println(familyIvanov.getInfo());
//        familyIvanov.sortByLastName();
//        System.out.println(familyIvanov.getInfo());
//        familyIvanov.sortById();
//        System.out.println(familyIvanov.getInfo());
//        familyIvanov.sortByNumberOfChildren();
//        System.out.println(familyIvanov.getInfo());
//
//
//        familyIvanov.writeFamilyTreeToFile("Ivanov.txt");
//
//    }

}
