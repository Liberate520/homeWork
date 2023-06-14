import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TreeService Service = new TreeService("SampleFree.txt");
        //Tree tree = (Tree) FH.loadFile();

        //Person prs_1 = new Person("Иванов", "Семён", "Матвеевич", "М");
        Service.addPerson("Иванов", "Семён", "Матвеевич", "М", LocalDate.of(1990,10,23));
        Service.addPerson("Петрова", "Анна", "Андреевна", "F", LocalDate.of(1993,3,20));
        Service.addPerson("Абрамова", "Марина", "Семёновна", "F", LocalDate.of(2013,7,10));

        //prs_3.setFather(prs_1);
        //prs_3.setMother(prs_2);

        //prs_1.showChildren();
        //prs_2.showChildren();

        System.out.println(Service.getTreeInfo());
        System.out.println(Service.getPersonsInfo());

        Service.sortByName();
        System.out.println(Service.getPersonsInfo());

        Service.sortByAge();
        System.out.println(Service.getPersonsInfo());

        //FH.saveFile((Serializable) tree);
    }
}
