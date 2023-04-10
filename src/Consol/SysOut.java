package Consol;
import java.util.Scanner;

import SaveAndLoad.*;
import Person.*;
import Tree.*;

//НЕЗАВЕРШЕН (ПОДГОТОВКА)!!!

public class SysOut {

    public static void getAllPersonFromList(Tree<Person> familytree) {
        for (int i = 0; i < familytree.getPersonList().size(); i++) {
            System.out.println((i+1) + ". " + ((Person) familytree.getPersonList().get(i)).getFullName());
        }
    }

    /**
     * Вызов пользовательского интерфейса
     * @param familytree Список семейного древа
     */
    public static void SysOut(Tree<Person> familytree) {

        Scanner scn = new Scanner(System.in,"ibm866");
        System.out.println();
        System.out.println("Выберите интересующий вас пункт ");
        System.out.println("1. Показать семейное древо ");
        System.out.println("2. Показать дату рождения человека ");
        System.out.println("3. Показать Родителей человека ");
        System.out.println("4. Показать детей человека ");
        System.out.println("5. Показать жив человек или нет ");
        System.out.println("6. показать дату смерти человека ");
        System.out.println("7. Добавить нового человека семьи ");
        System.out.println("8. Сохранить семейное древо ");
        System.out.println("9. Выход из программы ");

        int answer = scn.nextInt();
        System.out.println();

        while(answer < 1 || answer > 9){
            System.out.println("Выберете интересующий вас пункт: ");
            System.out.println("1. Показать семейное древо ");
            System.out.println("2. Показать дату рождения человека ");
            System.out.println("3. Показать Родителей человека ");
            System.out.println("4. Показать детей человека ");
            System.out.println("5. Показать жив человек или нет ");
            System.out.println("6. показать дату смерти человека ");
            System.out.println("7. Добавить нового человека семьи ");
            System.out.println("8. Сохранить семейное древо ");
            System.out.println("9. Выход из программы ");

            answer = scn.nextInt();
            System.out.println();

        }
        if (answer == 1){
            System.out.print(familytree.getInfo());
        }
        if (answer == 2){
            System.out.println("Выберете человека для просмотра даты рождения: ");
            getAllPersonFromList(familytree);
            System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
            answer = scn.nextInt();
            System.out.println();

            while(answer < 1 || answer > familytree.getPersonList().size() + 1){
                System.out.println("Выберете человека для просмотра даты рождения: ");
                getAllPersonFromList(familytree);
                System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
                answer = scn.nextInt();
                System.out.println();
            }
            if(answer < familytree.getPersonList().size() + 1){
                System.out.print(familytree.getPersonList().get(answer - 1).getDateOfBirth());
                System.out.println();
            }
            answer = 0;
        }
        if (answer == 3){
            System.out.println("Выберете человека для просмотра его родителей: ");
            getAllPersonFromList(familytree);
            System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
            answer = scn.nextInt();
            System.out.println();

            while(answer < 1 || answer > familytree.getPersonList().size() + 1){
                System.out.println("Выберете человека для просмотра его родителей: ");
                getAllPersonFromList(familytree);
                System.out.println((familytree.getPersonList().size() +1) + ". Возвратится в меню ");
                answer = scn.nextInt();
                System.out.println();
            }
            if(answer < familytree.getPersonList().size() + 1){
                System.out.print(familytree.getPersonList().get(answer - 1).getMotherInfo());
                System.out.print(familytree.getPersonList().get(answer - 1).getFatherInfo());
                System.out.println();
            }
            answer = 0;
        }
        if (answer == 4){

            System.out.println("Выберете человека для просмотра его детей: ");
            getAllPersonFromList(familytree);
            System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
            answer = scn.nextInt();
            System.out.println();

            while(answer < 1 || answer > familytree.getPersonList().size() + 1){
                System.out.println("Выберете человека для просмотра его детей: ");
                getAllPersonFromList(familytree);
                System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
                answer = scn.nextInt();
                System.out.println();
            }
            if(answer < familytree.getPersonList().size() + 1){
                System.out.print(familytree.getPersonList().get(answer - 1).getChildrenInfo());
                System.out.println();
            }
            answer = 0;
        }
        if (answer == 5){
            System.out.println("Выберете человека для просмотра жив или нет: ");
            getAllPersonFromList(familytree);
            System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
            answer = scn.nextInt();
            System.out.println();

            while(answer < 1 || answer > familytree.getPersonList().size() + 1){
                System.out.println("Выберете человека для просмотра жив или нет: ");
                getAllPersonFromList(familytree);
                System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
                answer = scn.nextInt();
                System.out.println();
            }
            if(answer < familytree.getPersonList().size() + 1){
                System.out.print(familytree.getPersonList().get(answer - 1).getAlive());
                System.out.println();
            }
            answer = 0;
        }
        if (answer == 6){
            System.out.println("Выберете человека для просмотра даты смерти: ");
            getAllPersonFromList(familytree);
            System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
            answer = scn.nextInt();
            System.out.println();

            while(answer < 1 || answer > familytree.getPersonList().size() + 1){
                System.out.println("Выберете человека для просмотра даты смерти: ");
                getAllPersonFromList(familytree);
                System.out.println((familytree.getPersonList().size() + 1) + ". Возвратится в меню ");
                answer = scn.nextInt();
                System.out.println();
            }
            if(answer < familytree.getPersonList().size() + 1){
                System.out.print(familytree.getPersonList().get(answer - 1).getDateOfDeath());
                System.out.println();
            }
            answer = 0;
        }
        if (answer == 7){
            Person new_person = new Person(null, null);
            System.out.println("Введите имя: ");
            new_person.setFirstName(scn.next());
            System.out.println("Введите фамилию: ");
            new_person.setSecondName(scn.next());
            System.out.println("Введите дату рождения: ");
            new_person.setDateOfBirth(scn.next());
            System.out.println("Выберите жив или нет: ");
            System.out.println("1. Жив ");
            System.out.println("2. Мертв ");
            answer = scn.nextInt(); 
            System.out.println();

            while(answer < 1 || answer > 2){
                System.out.println("Выберите жив или нет: ");
                System.out.println("1. Жив ");
                System.out.println("2. Мертв "); 
                answer = scn.nextInt(); 
                System.out.println();
            }
            if (answer == 1){
                new_person.setAlive(true);
                System.out.println();
            }
            if(answer == 2){
                new_person.setAlive(false);
                System.out.println("Введите дату смерти: ");
                new_person.setDateOfDeath(scn.next());
                System.out.println();
            }

            familytree.add(new_person);
            System.out.println(new_person.getFullName() + " добавлен(а) в семейное древо ");
            answer = 0;
            System.out.println();
        }
        if (answer == 8){
            familytree.save(familytree,"FamilyTree.txt");
            System.out.println("Семейное древо сохранено ");
            answer = 0;
        }

        if (answer != 9){
            SysOut(familytree);
        }
    scn.close();
    }
}
