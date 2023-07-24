
import java.io.Serializable;
import java.time.LocalDate;

import model.FileHandler;
import model.Gender;
import model.Human;
import model.Service;
import view.Console;
import view.View;

public class Main {

    public static void main(String[] args) {
        
        View view = new Console();
        view.start();



        // Service service = new Service();
        // Human olgaKartaeva = new Human("Olga", "Serduk", LocalDate.of(1965, 3, 13), Gender.Female);
        // Human sergeyKartaev = new Human("Sergey", "Kartaev", LocalDate.of(1964, 6, 15), Gender.Male);

        // Human nikolayKartaev = new Human("Nikolay", "Kartaev", LocalDate.of(1987, 1,
        //         3), olga1Kartaeva, sergeyKartaev,
        //         Gender.Male);
        // Human anastasiaKartaeva = new Human("Anastasia", "Kartaeva", LocalDate.of(1986, 8, 26), Gender.Female);
        // Human platonKartaev = new Human("Platon", "Kartaev", LocalDate.of(2022, 1, 30), Gender.Male);
        // Human ivanKartaev = new Human("Ivan", "Kartaev", LocalDate.of(1990, 12, 14), Gender.Male);
        // Human vladMakarov = new Human("Vlad", "Makarov", LocalDate.of(2004, 06, 13), Gender.Male);

        // // nikolayKartaev.addChildF(platonKartaev);
        // anastasiaKartaeva.addChildM(platonKartaev);

        // // olgaKartaeva.addChildM(nikolayKartaev);
        // // sergeyKartaev.addChildF(nikolayKartaev);

        // olgaKartaeva.addChildM(ivanKartaev);
        // sergeyKartaev.addChildF(ivanKartaev);
        // anastasiaKartaeva.addChildM(vladMakarov);

       

        // service.addHuman("Platon", "Kartaev", LocalDate.of(2022, 1, 30), anastasiaKartaeva, nikolayKartaev,
        //         Gender.Male);
        // service.addHuman("Nikolay", "Kartaev", LocalDate.of(1987, 1, 3), olgaKartaeva, sergeyKartaev,
        //         Gender.Male);
        // service.addHuman("Ivan", "Kartaev", LocalDate.of(1990, 12, 14), olgaKartaeva, sergeyKartaev,
        //         Gender.Male);

        // System.out.println(service.getInformation());


        //запись
        // FileHandler fileHandler = new FileHandler();
        // fileHandler.write("family.out", service);

        //чтение
        // Serializable dataRead = (Serializable) fileHandler.read("family.out");
        // System.out.println("Прочитанные данные: " + dataRead);



        // service.sortByBirthdate();
        // System.out.println(service.getInformation());

        // service.sortByAge();
        // System.out.println(service.getInformation());

        // service.sortByName();
        // System.out.println(service.getInformation());

        

    }
}
