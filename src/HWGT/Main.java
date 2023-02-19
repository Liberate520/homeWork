package HWGT;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Person> listOfPersons = new LinkedList<>();
        FamilyTree familyTree = new FamilyTree();
        String personName;
        String personSex;
        String fatherName;
        String matherName;
        Integer birthData;
        Integer deathData;
        Integer childName;

        String str = "";
        Scanner scanner1 = new Scanner(System.in, "UTF-8");

        while (!str.equals("0")){
            System.out.println("выберите пункт меню \n");
            System.out.println("1 - загрузить заранее подготовленый тестовый список имен");
            System.out.println("2 - продолжить с сохраненного списка");
            System.out.println("3 - ввести данные о новом человеке");
            System.out.println("4 - изменить данные человека");
            System.out.println("5 - ввести данные об окруженнии человека");
            System.out.println("6 - вывести всех всех людей в списке");
            System.out.println("7 - введите имя человека для поиска");
            System.out.println("8 - сохранить список");
            System.out.println("9 - сортировка списка по имени");
            System.out.println("10 - сортировка списка по дате рождения");
            System.out.println("0 - завершить работу");


            str = scanner1.next();



            switch (str){
                case ("1"):{
                    // создаем объект дерево содержащий соответствия - имя человека - его ближаейшее окружение
                    familyTree = fillAllPersons (familyTree);
                    familyTree.dellnull();
                    System.out.println("база тестовых данных загружена \n");
                    break;
                }
                case ("2"):{
                    familyTree = null;
//                    читаем ранее записаные списки людей и их связей
                    Repo repo1 = new Repo();
                    familyTree = (FamilyTree) repo1.read("familyTree.out");
                    System.out.println("база данных загружена \n");
                    break;
                }
                case ("3"): {
//                    3 - ввести данные о новом человеке"
                    familyTree = createNewPerson(familyTree);
                    break;
                }
                case ("4"): {
//                    4 - ввести изменения в запись"
                    familyTree = UpdatePerson(familyTree);
                    break;
                }
                case ("5"): {
//                    4 - ввести данные об окруженнии человека"
                    familyTree = addPersonEnvironment(familyTree);

                    break;
                }
                case ("6"): {
                    // выводим список всех людей в базе данных
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }



                    break;
                }
                case ("7"): {
//                    введите имя человека для поиска
                    searchPerson(familyTree);
                }
                case ("8"):{
//                    записываем списки людей и их связей
                    Repo repo1 = new Repo();
                    repo1.save((Serializable) familyTree, "familyTree.out");
                    System.out.println("база данных сохранена \n");
                    break;
                }
                case ("9"): {
//                    сортировка по имени
                    familyTree.sortByName();
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }
                    break;
                }
                case ("10"): {
//                    сортировка по дате рождения
                    familyTree.sortByBirth();
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }
                    break;
                }
                default:{
                    if (!str.equals("0")) {
                        System.out.println("неверный ключ");
                    }
                    break;
                }
            }
        }

        scanner1.close();
        System.out.println("До новых встреч! \n");
    }

    public static FamilyTree fillAllPersons (FamilyTree familyTree) {

        familyTree.setPerson(new Person("Ivan1","male", 1000, 1030,"Unknown", "Unknown", List.of()));
        familyTree.setPerson(new Person("Ivan2","male", 1021, 1040, "Unknown", "Unknown", List.of()));
        familyTree.setPerson(new Person("Vasiliy1","male", 1039, 1055, "Unknown", "Unknown", List.of()));
        familyTree.setPerson(new Person("Fedor1","male", 1034, 1060, "Unknown", "Unknown", List.of()));
        familyTree.setPerson(new Person("Sofia1","female", 1031, 1069, "Unknown", "Unknown", List.of()));

        familyTree.getPerson("Ivan1").setChildren("Ivan2");
        familyTree.getPerson("Ivan2").setChildren("Vasiliy1");
        familyTree.getPerson("Ivan2").setChildren("Fedor1");
        familyTree.getPerson("Ivan2").setChildren("Sofia1");

        return familyTree;
    }

    public static boolean checkName(FamilyTree familyTree, String name) {
//        если имя найдено в базе то true иначе false
        return (familyTree.getPerson(name) != null);
    }
    public static void searchPerson(FamilyTree familyTree){
        String nameForSearch="";
        System.out.println("введите имя человека для поиска \n");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        nameForSearch = scanner1.next();
//        scanner1.close();
        if (checkName(familyTree,nameForSearch))
        {
            System.out.println(familyTree.getPerson(nameForSearch));
        }
        else{

            System.out.println("человек с таким именем не найден");
        }
    }



    public static FamilyTree createNewPerson (FamilyTree familyTree){
        String personName;
        String personSex;
        Integer birthData;
        Integer deathData;

        System.out.println("Введите данные о новом человеке");
        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
//                    scanner1.close();
        if (checkName(familyTree, personName)){
            System.out.println("такой человек уже есть в базе даных \n");
        }
        else{
            System.out.println("Введите пол");
            personSex = scanner1.next();
            System.out.println("год рождения");
            birthData = scanner1.nextInt();
            System.out.println("год смерти");
            deathData = scanner1.nextInt();

            familyTree.setPerson(new Person(personName,personSex, birthData, deathData));
            System.out.println("человек добавлен \n");
        }
        return familyTree;
    }

    public static FamilyTree UpdatePerson (FamilyTree familyTree){
        String personName;
        Integer birthDate;
        Integer deathDate;

        System.out.println("Выберите человека для изменения данных об его окружени\n");
        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName(familyTree, personName)) {
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));
            System.out.println("введите год рождения или '0'\n");
            birthDate = scanner1.nextInt();
            if (birthDate > 0) {
                familyTree.getPerson(personName).setDateOfBirth(birthDate);
            }
            System.out.println("введите год смерти или '0'\n");
            deathDate = scanner1.nextInt();
            if (deathDate > 0) {
                familyTree.getPerson(personName).setDateOfDeath(deathDate);
            }
        }
        return familyTree;
    }





    public static FamilyTree addPersonEnvironment(FamilyTree familyTree){
        String personName;
        String personSex;
        String fatherName;
        String motherName;
        Integer birthData;
        Integer deathData;
        Integer childName;

        System.out.println("Выберите человека для изменения данных об его окружени\n");
        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName(familyTree, personName)){
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));
            System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
            fatherName = scanner1.next();
            if (!fatherName.equals("unknown")){
                if (checkName(familyTree, fatherName)) {
                    familyTree.getPerson(personName).setFather(fatherName);
                    familyTree.getPerson(fatherName).setChildren(personName);
                }
                else{
                    familyTree.getPerson(personName).setFather(fatherName);
                    familyTree.setPerson(new Person(fatherName,"male", 0, 0));
                    familyTree.getPerson(fatherName).setChildren(personName);
                }
            }
            System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
            motherName = scanner1.next();
            if (!motherName.equals("unknown")){
                if (checkName(familyTree, motherName)) {
                    familyTree.getPerson(personName).setMother(motherName);
                    familyTree.getPerson(motherName).setChildren(personName);
                }
                else{
                    familyTree.getPerson(personName).setMother(motherName);
                    familyTree.setPerson(new Person(motherName,"female", 0, 0));

                    familyTree.getPerson(motherName).setChildren(personName);
                }
            }
        }
        else{
            System.out.println("такого человека нет в базе даных \n");
        }
        return familyTree;
    }




}
