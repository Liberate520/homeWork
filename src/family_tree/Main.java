package family_tree;
import java.io.IOException;

import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }

    //     service.addHuman("Владимир", "Попов", "Александрович", Gender.MALE, 
    //                       "1991-07-12");

    //     service.addHuman("Александр", "Попов", "Витальевич", Gender.MALE, 
    //                       "1971-05-26");

    //     service.addHuman("Виталий", "Попов", "Сергеевич", Gender.MALE, 
    //                       "1945-08-01", "2015-02-16");
        
    //     service.addHuman("Марина", "Попова", "Игоревна", Gender.FAMALE, 
    //                       "1973-04-27");

    //     service.addHuman("Вероника", "Иванова", "Игоревна", Gender.FAMALE, 
    //                       "1975-09-14");

    //     service.addHuman("Маргарита", "Иванова", "Петровна", Gender.FAMALE, 
    //                       "1943-11-18", "2018-06-14");
        
    //     service.addKinship(0, 1, Kinship.PARENTS);
    //     service.addKinship(0, 3, Kinship.PARENTS);
    //     service.addKinship(1, 2, Kinship.PARENTS);
    //     service.addKinship(3, 5, Kinship.PARENTS);
    //     service.addKinship(4, 5, Kinship.PARENTS);
}
