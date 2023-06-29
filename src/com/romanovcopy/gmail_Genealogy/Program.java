package com.romanovcopy.gmail_Genealogy;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {


        //создаем семейную пару
        LocalDate johnDOB = LocalDate.of(1950, 1, 1);
        LocalDate maryDOB = LocalDate.of(1952, 6, 15);
        Person john = new Person("John", "Doe", johnDOB, Gender.MALE);
        john.setMaritalStatus(MaritalStatus.MARRIED);
        Person mary = new Person("Mary", "Smith", maryDOB, Gender.FEMALE);


        //создаем детей
        LocalDate peterDOB = LocalDate.of(1980, 3, 10);
        LocalDate annaDOB = LocalDate.of(1982, 8, 25);
        Person peter = new Person("Peter", "Doe", peterDOB, Gender.MALE);
        peter.setMaritalStatus(MaritalStatus.DIVORCED);
        Person anna = new Person("Anna", "Doe", annaDOB, Gender.FEMALE);

        //добавляем детей
        john.addChild("Peter Jr.", "Doe", peterDOB, Gender.MALE);
        john.addChild("Anna Jr.", "Doe", annaDOB, Gender.FEMALE);

        //вывод семьи
        System.out.println(john);
        System.out.println(mary);
        System.out.println(peter);
        System.out.println(anna);

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
        Person person = null;
        System.out.print("Фамилия : ");
        String surName = scanner.nextLine();
        System.out.println();
        System.out.println("Имя : ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Дата рождения :\n Число :");
        int dayDate = scanner.nextInt();
        System.out.println();
        return person;
    }

    private static String requestString(Scanner scanner) {
        String result=null;
        if (scanner.hasNext()) {
            result= scanner.next();}
        return result;
    }

    private static int requestInt(Scanner scanner) {
        int result = 0;
        if (scanner.hasNextInt()) {
            result = scanner.nextInt(); }
        return result;
    }
}
