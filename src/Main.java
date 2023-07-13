import familytree.Tree.Familytree;
import familytree.Tree.GetByOn;
import familytree.Tree.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main{



    public static void main(String[] args) throws IOException, ClassNotFoundException{
        // Создаем объекты класса Person
       //List<> familetrees = new ArrayList<>();
        Person petr = new Person("Петр", "Петров", "1970-01-01", "", "Мужской","");
        Person ira = new Person("Ира", "Петрова(Шутова)", "1972-05-10", "", "Женский","");
        Person anna = new Person("Анна", "Петрова", "1992-08-15", "", "Женский","");
        Person boris = new Person("Борис", "Петров", "1995-11-20", "", "Мужской","");

        Person tony = new Person("Тони", "Шварц", "1992-02-23", "", "Мужской","");
        Person anna1 = new Person("Анна", "Шварц(Петрова)", "1992-08-15", "", "Женский","");
        Person soniy = new Person("Соня", "Шварц", "2022-08-10", "", "Женский","");

        // ==== Создаем объект генеалогического древа
        Familytree familytree = new Familytree(petr);
        Familytree familytree1 = new Familytree(tony);
        //===== Заполняем древо
        familytree.addPerson(anna,petr,ira);//Их дети
        familytree.addPerson(boris,petr,ira);//Их дети
        familytree.addPerson(ira,petr);
        familytree.addPerson(boris,anna);

        familytree1.addPerson(soniy,tony,anna1);
        familytree1.addPerson(anna1,ira);
        familytree1.addPerson(anna1,petr);
        familytree1.addPerson(soniy,petr);
        familytree1.addPerson(soniy,ira);
        familytree1.addPerson(soniy,boris);

        // Выводим информацию
//=====================================================================
        ArrayList<Person> employees = new ArrayList<>();
        employees.add(petr);
        employees.add(ira);
        employees.add(anna);
        employees.add(boris);

      /* for(Person emp: employees){
           emp.printInfo();
       }*/

        System.out.println("===================================================================");
        ArrayList<Person> employees1 = new ArrayList<>();
        employees1.add(tony);
        employees1.add(anna1);
        employees1.add(soniy);

        /*for(Person emp: employees1){
            emp.printInfo();
        }*/
        System.out.println("===================================================================");
        System.out.println("===================================================================");
        ArrayList<Person> sortEmploees = new ArrayList<>();
        for(Person emp: employees){
            sortEmploees.add(emp);
        }
        for(Person emp: employees1){
            sortEmploees.add(emp);
        }
        /*for(Person emp: sortEmploees){
            emp.printInfo();
        }*/
        System.out.println();
        System.out.println("++++ Сортировка по фамилии +++++++++++++++++++++++++++++++++++++++++++++++++++");
        Collections.sort(sortEmploees, Comparator.comparing(o->o.getSurname()));
        Iterator<Person> iterator = sortEmploees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        /*for (Person employee : sortEmploees) {
            employee.printInfo();
        }*/
        System.out.println("+++++++ Сортировка по Имени ++++++++++++++++++++++++++++++++++++++++++++++++");
        Collections.sort(sortEmploees, Comparator.comparing(o->o.getName()));
        Iterator<Person> iteratorName = sortEmploees.iterator();
        while (iteratorName.hasNext()){
            System.out.println(iteratorName.next());
        }
        System.out.println();
        System.out.println("===================================================================");
//=====================================================================
        /*petr.printInfo();
        ira.printInfo();
        anna.printInfo();
        boris.printInfo();

        System.out.println();*/
/*

        // Выводим генеалогическое древо
        System.out.println("Генеалогическое древо");
        familytree.printFamilyTree();
        System.out.println("Генеалогическое древо2");
        familytree1.printFamilyTree();
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

*/
       /*Service service = new Service(familytree);
        System.out.println(service.getFamilyInfo());*/
    }


}
