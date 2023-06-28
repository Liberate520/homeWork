import familytree.Person;
import familytree.Familytree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты класса Person
        Person petr = new Person("Петр", "Петров", "1980-01-01", "", "Мужской");
        Person ira = new Person("Ира", "Петрова", "1982-05-10", "", "Женский");
        Person anna = new Person("Анна", "Сидорова", "2005-08-15", "", "Женский");
        Person boris = new Person("Борис", "Сидоров", "2008-11-20", "", "Мужской");

        // ==== Создаем объект генеалогического древа
        Familytree familytree = new Familytree((petr));
        //===== Заполняем древо
        //familytree.addPerson(ira,petr,petr);// Жена Петра
        familytree.addPerson(anna,petr,ira);//Их дети
        familytree.addPerson(boris,petr,ira);//Их дети
        familytree.addPerson(ira,petr);

        // Выводим информацию

        petr.printInfo();
        ira.printInfo();
        anna.printInfo();
        boris.printInfo();

        // Выводим генеалогическое древо
        System.out.println("Генеалогическое древо");
        familytree.printFamilyTree();

        //Поиск по имени
        /*System.out.println("Результат поиска по имени Petr");
        List<Person> searchResults = familytree.searchPersonsByName("petr");
        for(Person result : searchResults){
            result.printInfo();
        }*/
    }
}
