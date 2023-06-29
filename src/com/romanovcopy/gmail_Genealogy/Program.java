package com.romanovcopy.gmail_Genealogy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {


//        GenealogyGraph graph = new GenealogyGraph();
//
//        // Добавление людей в граф
//        graph.addPerson("John");
//        graph.addPerson("Mary");
//        graph.addPerson("Peter");
//
//        // Установление родительской связи
//        graph.addParentChildRelationship("John", "Peter");
//        graph.addParentChildRelationship("Mary", "Peter");
//
//        // Получение родителей и детей
//        List<Person> johnsParents = graph.getParents("John");
//        List<Person> marysChildren = graph.getChildren("Mary");
//
//        System.out.println("John's parents: " + johnsParents);
//        System.out.println("Mary's children: " + marysChildren);

    }

    private static void selectMode() {
        boolean flag = true;
        int mode = 0;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Выберите режим работы : ");
            System.out.printf("1 - $s", "Новый граф.\n");
            System.out.printf("2 - $s", "Редактировать граф.\n");
            System.out.printf("3 - $s", "Просмотр графа.\n");
            System.out.printf("4 - $s", "Удалить граф.\n\n");
            System.out.printf("0 - %s", "Выход");
            System.out.printf("** - $s -**", "Введите номер режима : ");
            if (scanner.hasNextInt()) {
                mode = Math.abs(scanner.nextInt());
                flag = mode != 0;
                if (flag) {
                    switch (mode) {
                        case 1: {
                            System.out.println("Новый граф");
                            var person=createPerson(scanner);
                            break;
                        }
                        case 2: {
                            System.out.println("Редактировать граф");

                            break;
                        }
                        case 3: {
                            System.out.println("Просмотр графа");

                            break;
                        }
                        case 4: {
                            System.out.println("Удаление графа");

                            break;
                        }
                        default: {
                            System.out.println("Неизвестный выбор.\nПовторите ввод.");
                        }
                    }


                }
            }
        }
        scanner.close();
    }

    private static Person createPerson(Scanner scanner) {
        boolean flag=true;
        Person person = null;
        String surName = null;
        while (flag){
            surName = requestString(scanner,"Фамилия : ", false);
            flag=surName==null||surName.length()==0;
        }
        String name = null;
        flag=true;
        while (flag){
            name = requestString(scanner,"Имя : ", false);
            flag=name==null||name.length()==0;
        }
        LocalDate birthDay=null;
        flag=true;
        requestString(scanner,"Отчество (если есть) : ", false);
        while (flag){
            birthDay=requestDate(scanner,"Дата рождения в формате дд.мм.гггг :", false);
            flag=birthDay==null;
        }

        return person;
    }

    /**
     * получение ввода в виде строки
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param neeLine переход на новую строку после текста запроса
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
     * @param neeLine переход на новую строку после текста запроса
     * @return число введенное пользователем
     */
    private static int requestInt(Scanner scanner, String text, boolean newLine) {
        newLine(text, newLine);
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt(); }
        return result;
    }

    /**
     * получение ввода в виде даты (LocalDate)
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param neeLine переход на новую строку после текста запроса
     * @return дата введенная пользователем
     */
    private static LocalDate requestDate(Scanner scanner, String text, boolean newLine){
        newLine(text, newLine);
        System.out.println("Введите дату рождения в формате DD.MM.YYYY :");
        // Устанавливаем формат даты, который ожидаем от пользователя
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthDay=scanner.nextLine();
        try {
            // Преобразовываем введенную строку в объект LocalDate с использованием заданного формата
            LocalDate date = LocalDate.parse(birthDay, dateFormatter);
            return date;
        } catch (Exception e) {
            System.out.println("Некорректный формат даты.");
            return null;
        }
    }

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
