package com.romanovcopy.gmail.Genealogy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class BasicMethods {


    /**
     * получение ввода в виде строки
     * @param scanner поток доступа к консоли
     * @param text текст запроса
     * @param newLine переход на новую строку после текста запроса
     * @return строка введенная пользователем
     */
    public String requestString(Scanner scanner, String text, boolean newLine) {
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
    public int requestInt(Scanner scanner, String text, boolean newLine) {
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
    public LocalDate requestDate(Scanner scanner, String text, boolean newLine){
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

    public void printPersons(ArrayList<Person> list){
        for(var pers:list){
            System.out.printf("%d %s", list.indexOf(pers)+1,pers.toString());
            System.out.println();
        }
    }

    /**
     * вывод текста
     * @param text текст
     * @param newLine перевод на новую строку в конце строки
     */
    public void newLine(String text, boolean newLine){
        if(newLine){
            System.out.println(text);
        }else {
            System.out.print(text);
        }
    }

    /**
     * получение ключа в библиотеке по значению
     * @param map библиотека
     * @param value значение
     * @return ключ или null, если дерево не найдено
     */
    public String getKeyByValue(HashMap<String,GenealogyGraph> map, GenealogyGraph value) {
        for (var entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }


}
