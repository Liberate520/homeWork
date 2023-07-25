import enums.Gender;
import treeWorkspace.Person;
import treeWorkspace.Service;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        // Заполняем тестовое дерево
        Service service = new Service();
        service.addPerson("Мария", Gender.Female,LocalDate.of(1900,12,25));
        service.addPerson("Иосиф", Gender.Male,LocalDate.of(1900,11,1));
        service.addPerson("София", Gender.Female,LocalDate.of(1920,11,1));
        service.addPerson("Виктор", Gender.Male,LocalDate.of(1925,11,1));
        // Выводим на экран
        for (Person p:service.getCurrentTree()){
            System.out.println(p);
        }
        //
    }
}
