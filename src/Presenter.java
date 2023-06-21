
import java.security.Provider;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class Presenter {
    private TreeService Service;

    public Presenter(){
        this.Service = new TreeService();
        Service.addPerson("Иванов", "Семён", "Матвеевич", "М", LocalDate.of(1990,10,23));
        Service.addPerson("Петрова", "Анна", "Андреевна", "F", LocalDate.of(1993,3,20));
        Service.addPerson("Абрамова", "Марина", "Семёновна", "F", LocalDate.of(2013,7,10));

        Service.addPersonParents(2,1,"Mother");
    }
    public void addNote(String lastName, String name, String middleName, String sex, LocalDate bTime) {
        Service.addPerson(lastName, name, middleName, sex, bTime);
    }
    public void getNote(String number) {
        System.out.println(Service.getPersonById(parseInt(number)));
    }

    public void getTreeInfo() {
        System.out.println(Service.getTreeInfo());
    }

    public void getSortIdList(){
        System.out.println(Service.getPersonsInfo());
    }

    public void saveFile(){
        Service.SaveLoad("SampleFree.txt", "Save");
    }

    public void loadFile(){
        Service.SaveLoad("SampleFree.txt", "Load");
    }

}
