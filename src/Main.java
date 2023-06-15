import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TreeService Service = new TreeService();

        //Service.SaveLoad("SampleFree.txt", "Load");

        Service.addPerson("Иванов", "Семён", "Матвеевич", "М", LocalDate.of(1990,10,23));
        Service.addPerson("Петрова", "Анна", "Андреевна", "F", LocalDate.of(1993,3,20));
        Service.addPerson("Абрамова", "Марина", "Семёновна", "F", LocalDate.of(2013,7,10));

        Service.addPersonParents(2,1,"Mother");
        Service.showChildrenById(1);

        System.out.println(Service.getTreeInfo());
        System.out.println(Service.getPersonsInfo());

        Service.sortByName();
        System.out.println(Service.getPersonsInfo());

        Service.sortByAge();
        System.out.println(Service.getPersonsInfo());

        //System.out.println(Service.getPersonById(2));
        //Service.SaveLoad("SampleFree.txt", "Save");
    }
}
