import java.io.*;

public class Main implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new View();
        view.start();
        //Family<Human> family = new Family<>();
        //Service service = new Service(family);

        //Human granA = new Human("Ekaterina", Gender.WOMAN, 1942, null, null);
        //Human dadA = new Human("Ivan", Gender.MAN, 1969, null,granA);
        //Human granB = new Human("Mikhail", Gender.MAN, 1961, null,null);
        //Human granC = new Human("Anastasia", Gender.WOMAN, 1973, null,null);
        //Human momA = new Human("Julia", Gender.WOMAN, 1993, granB,granC);
        //Human momB = new Human("Vika", Gender.WOMAN, 1987, granB,null);
        //Human momD = new Human("Maria", Gender.WOMAN, 1966, null,null);
        //Human sonA = new Human("Petr", Gender.MAN, 1992, dadA,momD);
        //Human granson1 = new Human("Daria", Gender.WOMAN, 2020, sonA,momA);
        //Human granson2 = new Human("Vasia", Gender.MAN, 2017, sonA,momA);
        //Human granson3 = new Human("Jurii", Gender.MAN, 2014, sonA,momA);

        //service.addPerson(granA);
        //service.addPerson(dadA);
        //service.addPerson(granB);
        //service.addPerson(granC);
        //service.addPerson(momA);
        //service.addPerson(momB);
        //service.addPerson(momD);
        //service.addPerson(sonA);
        //service.addPerson(granson2);
        //service.addPerson(granson3);
        //service.addPerson(granson1);

        //service.save(family);
        //Family read = service.read();
        //System.out.println(read);
        //System.out.println();

        //Human found = family.search("Ivan");
        //StringBuilder broAndSis = family.getBroAndSis("Vasia");
        //System.out.println(broAndSis);
        //StringBuilder broAndSis2 = family.getBroAndSis("Julia");
        //System.out.println(broAndSis2);
        //StringBuilder broAndSis3 = family.getBroAndSis("Ivan");
        //System.out.println(broAndSis3);
        //System.out.println();

        //сортировка по алфавиту
        //service.sortByName();
        //System.out.println(family);
        //System.out.println();

        //сортировка по году рождения
        //service.sortByYearBirth();
        //System.out.println(family);


    }
}
