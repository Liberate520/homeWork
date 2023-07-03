import familytree.IOFile;
import familytree.InputOutputFile;
import familytree.Person;
import familytree.Familytree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{



    public static void main(String[] args) throws IOException, ClassNotFoundException{
        // Создаем объекты класса Person
        Person petr = new Person("Петр", "Петров", "1980-01-01", "", "Мужской","");
        Person ira = new Person("Ира", "Петрова", "1982-05-10", "", "Женский","");
        Person anna = new Person("Анна", "Сидорова", "2005-08-15", "", "Женский","");
        Person boris = new Person("Борис", "Сидоров", "2008-11-20", "", "Мужской","");


        // ==== Создаем объект генеалогического древа
        //Person root = new Person("Петр","1980-01-01");
        //Familytree familyTree = new Familytree(root);
        Familytree familytree = new Familytree((petr));
        //===== Заполняем древо
        //familytree.addPerson(ira,petr,petr);// Жена Петра
        familytree.addPerson(anna,petr,ira);//Их дети
        familytree.addPerson(boris,petr,ira);//Их дети
        familytree.addPerson(ira,petr);
        familytree.addPerson(boris,ira);
        familytree.addPerson(boris,anna);



        // Выводим информацию

        petr.printInfo();
        ira.printInfo();
        anna.printInfo();
        boris.printInfo();

        System.out.println();

        // Выводим генеалогическое древо
        System.out.println("Генеалогическое древо");
        familytree.printFamilyTree();
        //---------------------------------------

        // ===Создаю экземпляр репозитория

        IOFile iofile = new InputOutputFile();
        // Сохранение генеалогического древа в файл
        String fileName = "family_tree.dat";
        iofile.saveFamilyTree(familytree, fileName);

        // Загрузка генеалогического древа из файла
        Familytree loadedFamilyTree = iofile.loadFamilyTree(fileName);
        System.out.println("Генеалогическое древо из ФАЙЛА");
       loadedFamilyTree.printFamilyTree();
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++

        //Поиск по имени
        /*System.out.println("Результат поиска по имени Petr");
        List<Person> searchResults = familytree.searchPersonsByName("petr");
        for(Person result : searchResults){
            result.printInfo();
        }*/
    }
}
