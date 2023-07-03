package com.romanovcopy.gmail.Genealogy;

import java.time.LocalDate;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    private static Scanner scanner;
    private static Service service;
    private static HashMap<String, GenealogyGraph>genealogyGraphHashMap;

    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        start();
        scanner.close();
    }

    /**
     * запуск программы
     */
    public static void start(){
        if(genealogyGraphHashMap==null || genealogyGraphHashMap.size()==0){
            genealogyGraphHashMap = new HashMap<>();
            while (!createGeneallogyGraph()){
                if(requestInt(scanner,"0 - продолжить \n1 - выйти из программы",false)!=0){
                    return;
                }
            }
        }
        String name=null;
        boolean flag=true;
        while (flag){
            for(String key:genealogyGraphHashMap.keySet()){
                System.out.println(key);
            }
            name=requestString(scanner,"Введите имя дерева из доступных : ", true);
            if(name!=null && genealogyGraphHashMap.keySet().contains(name)){
                if(service==null){
                    service=new Service(scanner, genealogyGraphHashMap.get(name));
                }
                else {
                    service.selectMode(genealogyGraphHashMap.get(name));
                }
            }
            else{
                flag=requestInt(scanner,"Выйти из программы ?\n 0 - No\n1 - Yes",true)==0;
            }
        }
    }

    /**
     * создание нового дерева
     * @return результат: True - удачно; False - неудачно
     */
    public static boolean createGeneallogyGraph() {
        System.out.println("Будет создано новое генеалогическое дерево.\n");
        String name = requestString(scanner, "Присвойте ему имя : ", false);
        if (name != null && name.length() > 3) {
            if (genealogyGraphHashMap.keySet().contains(name)) {
                System.out.println("Дерево с таким именем уже существует.");
                return false;
            } else {
                GenealogyGraph graph=new GenealogyGraph();
                genealogyGraphHashMap.put(name,graph);
                if(service==null){
                    service=new Service(scanner, graph);
                }
                else {
                    service.selectMode(graph);
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * обновление старого или добавление нового дерева
     * @param graph добовляемое/обновляемое дерево
     * @return результат выполнения
     */
    public static boolean updateGenealogyGraph(GenealogyGraph graph){

        return  true;
    }

    /**
     * удаление дерева
     * @param graph удаляемое дерево
     * @return результат выполнения
     */
    public static boolean removeGenealogyGraph(GenealogyGraph graph){

        return true;
    }






//    private static void selectMode(GenealogyGraph graph) {
//        boolean flag = true;
//        int mode = 0;
//        while (flag) {
//            System.out.println("Выберите режим работы : ");
//            System.out.println("1 - Новый граф.");
//            System.out.println("2 - Редактировать граф.");
//            System.out.println("3 - Просмотр графа.");
//            System.out.println("4 - Удалить граф.");
//            System.out.println("5 - Вывести все графы");
//            System.out.println("0 - Выход");
//            System.out.println("Введите номер режима : ");
//            if (scanner.hasNextInt()) {
//                mode = Math.abs(scanner.nextInt());
//                flag = mode != 0;
//                if (flag) {
//                    switch (mode) {
//                        case 1: {
//                            System.out.println("Новый граф");
//                            var person=createPerson(scanner);
//                            if(person!=null){
//                                graph.addPerson(person);
//                            }
//                            break;
//                        }
//                        case 2: {
//                            personEditing(scanner, graph);
//                            break;
//                        }
//                        case 3: {
//                            System.out.println("Просмотр графа");
//
//                            break;
//                        }
//                        case 4: {
//                            System.out.println("Удаление графа");
//
//                            break;
//                        }
//                        default: {
//                            System.out.println("Неизвестный выбор.\nПовторите ввод.");
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * Создание нового персонажа
//     * @param scanner поток чтения с консоли
//     * @return новый персонаж
//     */
//    private static Person createPerson(Scanner scanner) {
//        boolean flag=true;
//        Person person = null;
//        String surName = null;
//        while (flag){
//            surName = requestString(scanner,"Фамилия : ", false);
//            flag=surName==null||surName.length()==0;
//        }
//        String name = null;
//        flag=true;
//        while (flag){
//            name = requestString(scanner,"Имя : ", false);
//            flag=name==null||name.length()==0;
//        }
//        String patronymic = requestString(scanner,"Отчество (если есть) : ", false);
//        Gender gender=null;
//        flag=true;
//        while (flag){
//            String temp=requestString(scanner,"Выберите пол : (MALE,FEMALE) ",false);
//            // Преобразуем введенную строку в Enum-значение
//            try {
//                gender = Gender.valueOf(temp.toUpperCase());
//                System.out.println("Выбранный пол: " + gender);
//                flag=false;
//            } catch (IllegalArgumentException e) {
//                System.out.println("Некорректное значение.");
//            }
//        }
//        MaritalStatus maritalStatus=null;
//        String text="Выберите семейное положение : ( SINGLE, MARRIED, DIVORCED, WIDOWED ) ";
//        flag=true;
//        while (flag){
//            String temp=requestString(scanner,text,false);
//            // Преобразуем введенную строку в Enum-значение
//            try {
//                maritalStatus = MaritalStatus.valueOf(temp.toUpperCase());
//                System.out.println("Выбрано семейное положение: " + maritalStatus);
//                flag=false;
//            } catch (IllegalArgumentException e) {
//                System.out.println("Некорректное значение.");
//            }
//        }
//        LocalDate birthDay=null;
//        flag=true;
//        while (flag){
//            birthDay=requestDate(scanner,"Дата рождения в формате дд.мм.гггг :", false);
//            flag=birthDay==null;
//        }
//        person=new Person(name, surName, patronymic,birthDay,gender,maritalStatus);
//        return person;
//    }
//
//    private static Person personEditing(Scanner scanner, GenealogyGraph graph) {
//        Person person = null;
//        System.out.println("Редактировать граф");
//        var str = requestString(scanner, "Строка поиска : ", false);
//        var listSelcted = graph.search(str);
//        printPersons(listSelcted);
//        person = listSelcted.get(requestInt(scanner, "Выберите номер персонажа : ", false) - 1);
//        return person;
//    }

    /**
     * получение ввода в виде строки
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param newLine переход на новую строку после текста запроса
     * @return строка введенная пользователем
     */
    private static String requestString(Scanner scanner, String text, boolean newLine) {
        newLine(text, newLine);
        String result=null;
        if (scanner.hasNext()) {
            result= scanner.next();}
        return result;
    }

    /**
     * получение ввода в виде целого числа
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param newLine переход на новую строку после текста запроса
     * @return число введенное пользователем
     */
    private static int requestInt(Scanner scanner, String text, boolean newLine) {
        newLine(text, newLine);
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt();}
        return result;
    }

    /**
     * получение ввода в виде даты (LocalDate)
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param newLine переход на новую строку после текста запроса
     * @return дата введенная пользователем
     */
    private static LocalDate requestDate(Scanner scanner, String text, boolean newLine){
        newLine(text, newLine);
        // Устанавливаем формат даты, который ожидаем от пользователя
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthDay=scanner.next();
        try {
            // Преобразовываем введенную строку в объект LocalDate с использованием заданного формата
            LocalDate date = LocalDate.parse(birthDay, dateFormatter);
            return date;
        } catch (Exception e) {
            System.out.println("Некорректный формат даты.");
            return null;
        }
    }

//    private static void printPersons(ArrayList<Person>list){
//        for(var pers:list){
//            System.out.printf("%d %s", list.indexOf(pers)+1,pers.toString());
//            System.out.println();
//        }
//    }

    /**
     * вывод текста
     * @param text текст
     * @param newLine перевод на новую строку в конце строки
     */
    private static void newLine(String text, boolean newLine){
        if(newLine){
            System.out.println(text);
        }else {
            System.out.print(text);
        }
    }

}
