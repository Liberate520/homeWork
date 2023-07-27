import enums.Gender;
import treeWorkspace.Person;
import treeWorkspace.Service;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        // Заполняем тестовое дерево
        Service<Person> service = new Service<>();
        service.addPerson("Мария", Gender.Female,
                LocalDate.of(1900, 12, 25),
                LocalDate.of(1955, 1, 16));

        service.addPerson("Иосиф", Gender.Male,
                LocalDate.of(1900, 11, 1),
                LocalDate.of(1960, 5, 16));

        service.addPerson("София", Gender.Female,
                        LocalDate.of(1920, 11, 1),
                        LocalDate.of(2000, 1, 16))
                .addParent(service.findPerson(0))
                .addParent(service.findPerson(1));

        service.addPerson("Виктор", Gender.Male,
                        LocalDate.of(1925, 11, 1),
                        LocalDate.of(2007, 1, 16))
                .addParent(service.findPerson(0))
                .addParent(service.findPerson(1));
        service.addPerson("Ильнар", Gender.Male,
                LocalDate.of(1955, 12, 31),
                null);
        // Выводим на экран
        service.getInfo();
//        service.sortByName();
//        service.sortByAge();
//        service.sortByGender();
        System.out.println();
//        service.getInfo();
        // Проверка сохранения и загрузки
        service.saveTree("./src/savedFiles/TreeOfHumans.bin");
        System.out.println(service.loadTree("./src/savedFiles/TreeOfHumans.bin"));
    }
}
