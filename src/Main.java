import java.io.IOException;

import Consol.SysOut;
import Person.Person;
import Tree.FamilyTree;
import Tree.Tree;



public class Main {

    
    static Person person1 = new Person("Сергей", "Манеров", "18.04.1996");
            
    static Person person2 = new Person("Оксана", "Вилкова", "12.10.1976");

    static Person person3 = new Person("Денис", "Манеров", "11.10.1968");

    static Person person4 = new Person("Вероника", "Вилкова", "04.03.2006");


        
    public static void main(String[] args) throws ClassNotFoundException, IOException  {

        Tree <Person> familytree = new FamilyTree<>();
        Sort familyIterator = new Sort(familytree.getPersonList());

        // Добавление детей людям
        person2.addChild(person1);
        person3.addChild(person1);
        person2.addChild(person4);

        // Задаем жив человек или нет
        person1.setAlive(true);
        person2.setAlive(true);
        person3.setAlive(true);
        person4.setAlive(true);

        // Задаем родителей человека
        person1.setMother(person2);
        person1.setFather(person3);
        person4.setMother(person2);

       // Добавление человека в семейное дерево
        familytree.add(person1);
        familytree.add(person2);
        familytree.add(person3);
        familytree.add(person4);


        // Получение информации по человеку по отдельным позициям
        person1.getFirstName();
        person1.getSecondName();
        person1.getDateOfBirth();
        person1.getAlive();
        person1.getDateOfDeath();
        person1.getMother();
        person1.getFather();
        person1.getChildrens();

        // // Вывод полной информации по людям 
        // System.out.println(person1);
        // System.out.println();
        // System.out.println(person2);
        // System.out.println();
        // System.out.println(person3);
        // System.out.println();
        // System.out.println(person4);
        // System.out.println();

        // // Вывод малой информации по людям
        // System.out.println(person1.getInfo());
        // System.out.println();
        // System.out.println(person2.getInfo());
        // System.out.println();

        // // Вывод семейного древа
        // System.out.print(familytree.getInfo());


        // // Сортировки:
        // // По количеству детей
        // familyIterator.sortByChild();
        // for(Person person: familytree){
        //     System.out.println(person);
        // }
        // System.out.println();
        
        // // По Имени
        // familyIterator.sortByName();
        // for(Person person: familytree){
        //     System.out.println(person);
        // }
        // System.out.println();

        // // По Фамилии
        // familyIterator.sortBySecondName();
        // for(Person person: familytree){
        //     System.out.println(person);
        // }
        // System.out.println();

        // // По нахождению в живых
        // familyIterator.sortByAlive();
        // for(Person person: familytree){
        //     System.out.println(person);
        // }
    
        // // Сохранение в файл
        // SaveLoad.save(familytree,"FamilyTree.txt");

        SysOut.SysOut(familytree);
    }
}