
import java.io.Serializable;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        Human olgaKartaeva = new Human("Olga", "Serduk", LocalDate.of(1965, 3, 13), Gender.Female);
        Human sergeyKartaev = new Human("Sergey", "Kartaev", LocalDate.of(1964, 6, 15), Gender.Male);

        Human nikolayKartaev = new Human("Nikolay", "Kartaev", LocalDate.of(1987, 1, 3), olgaKartaeva, sergeyKartaev,
                Gender.Male);
        Human anastasiaKartaeva = new Human("Anastasia", "Kartaeva", LocalDate.of(1986, 8, 26), Gender.Female);
        Human platonKartaev = new Human("Platon", "Kartaev", LocalDate.of(2022, 1, 30), Gender.Male);
        Human ivanKartaev = new Human("Ivan", "Kartaev", LocalDate.of(1990, 12, 14), Gender.Male);
        Human vladMakarov = new Human("Vlad", "Makarov", LocalDate.of(2004, 06, 13), Gender.Male);

        nikolayKartaev.addChildF(platonKartaev);
        anastasiaKartaeva.addChildM(platonKartaev);

        olgaKartaeva.addChildM(nikolayKartaev);
        sergeyKartaev.addChildF(nikolayKartaev);

        olgaKartaeva.addChildM(ivanKartaev);
        sergeyKartaev.addChildF(ivanKartaev);

        anastasiaKartaeva.addChildM(vladMakarov);

        // System.out.println(nikolayKartaev);
        // System.out.println(anastasiaKartaeva);
        // System.out.println(platonKartaev);
        // System.out.println(sergeyKartaev);
        // System.out.println(olgaKartaeva);
        // System.out.println(ivanKartaev);
        // System.out.println(vladMakarov);

        family.add(nikolayKartaev);
        family.add(anastasiaKartaeva);
        family.add(platonKartaev);
        family.add(ivanKartaev);
        family.add(olgaKartaeva);

        System.out.println(family.getInformation());

        FileHandler fileHandler = new FileHandler();
        fileHandler.write("JAVA/HW/homeWork/src/family.out", family);

        Serializable dataRead = (Serializable) fileHandler.read("JAVA/HW/homeWork/src/family.out");
        System.out.println("Прочитанные данные: " + dataRead);
    }
}
