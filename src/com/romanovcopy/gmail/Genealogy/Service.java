package com.romanovcopy.gmail.Genealogy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Service extends BasicMethods{

    private Scanner scanner;
    private HashMap<String, GenealogyGraph>genealogyGraphHashMap;



    public Service(Scanner scanner){
        this.scanner=scanner;
    }

    /**
     * работа с деревом
     * @param graph дерево
     */
    public void selectMode(GenealogyGraph graph) {
        boolean flag = true;
        int mode = 0;
        while (flag) {
            System.out.println("Выберите режим работы : ");
            System.out.println("1 - Новый граф.");
            System.out.println("2 - Редактировать граф.");
            System.out.println("3 - Просмотр графа.");
            System.out.println("4 - Удалить граф.");
            System.out.println("5 - Вывести все графы");
            System.out.println("0 - Выход");
            System.out.println("Введите номер режима : ");
            if (scanner.hasNextInt()) {
                mode = Math.abs(scanner.nextInt());
                flag = mode != 0;
                if (flag) {
                    switch (mode) {
                        case 1: {
                            System.out.println("Новый граф");
                            var person=createPerson(scanner);
                            if(person!=null){
                                graph.addPerson(person);
                            }
                            break;
                        }
                        case 2: {
                            personEditing(scanner, graph);
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
                    if(!updateGenealogyGraph(graph)){
                        System.out.println("Дерево не было обновлено.");
                    }else {
                        System.out.println("Дерево успешно обновлено");
                    }
                }
            }
        }
    }

    /**
     * Создание нового персонажа
     * @param scanner поток чтения с консоли
     * @return новый персонаж
     */
    private Person createPerson(Scanner scanner) {
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
        String patronymic = requestString(scanner,"Отчество (если есть) : ", false);
        Gender gender=null;
        flag=true;
        while (flag){
            String temp=requestString(scanner,"Выберите пол : (MALE,FEMALE) ",false);
            // Преобразуем введенную строку в Enum-значение
            try {
                gender = Gender.valueOf(temp.toUpperCase());
                System.out.println("Выбранный пол: " + gender);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение.");
            }
        }
        MaritalStatus maritalStatus=null;
        String text="Выберите семейное положение : ( SINGLE, MARRIED, DIVORCED, WIDOWED ) ";
        flag=true;
        while (flag){
            String temp=requestString(scanner,text,false);
            // Преобразуем введенную строку в Enum-значение
            try {
                maritalStatus = MaritalStatus.valueOf(temp.toUpperCase());
                System.out.println("Выбрано семейное положение: " + maritalStatus);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное значение.");
            }
        }
        LocalDate birthDay=null;
        flag=true;
        while (flag){
            birthDay=requestDate(scanner,"Дата рождения в формате дд.мм.гггг :", false);
            flag=birthDay==null;
        }
        person=new Person(surName, name, patronymic,birthDay,gender,maritalStatus);
        return person;
    }

    /**
     * запуск программы
     */
    public void start(HashMap<String, GenealogyGraph> genealogyGraphHashMap){
        //создание библиотеки для хранения дервевьев
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
            //вывод доступных деревьев
            for(String key:genealogyGraphHashMap.keySet()){
                System.out.println(key);
            }
            //запрос нужного дерева и переход к работе с ним
            name=requestString(scanner,"Введите имя дерева из доступных : ", true);
            if(name!=null && genealogyGraphHashMap.keySet().contains(name)){
                    selectMode(genealogyGraphHashMap.get(name));
            }
            else{
                String text = "Выйти из программы ?\n 0 - No\n1 - Yes\n2 - новое дерево";
                //запрос на выход или создание нового дерева, если дерево не выбрано
                int temp=requestInt(scanner,"Выйти из программы ?\n 0 - No\n1 - Yes",true);
                flag=temp!=0;
                if(temp==2){
                    createGeneallogyGraph();
                }
            }
        }
    }

    /**
     * создание нового дерева
     * @return результат: True - удачно; False - неудачно
     */
    public boolean createGeneallogyGraph() {
        System.out.println("Будет создано новое генеалогическое дерево.\n");
        String name = requestString(scanner, "Присвойте ему имя : ", false);
        if (name != null && name.length() > 3) {
            if (genealogyGraphHashMap.keySet().contains(name)) {
                System.out.println("Дерево с таким именем уже существует.");
                return false;
            } else {
                GenealogyGraph graph=new GenealogyGraph();
                genealogyGraphHashMap.put(name,graph);
                selectMode(graph);
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * обновление заданного дерева в библиотеке
     * @param graph обновляемое дерево
     * @return результат выполнения
     */
    public boolean updateGenealogyGraph(GenealogyGraph graph){
        if(genealogyGraphHashMap.containsValue(graph)){
            String key=getKeyByValue(genealogyGraphHashMap,graph);
            if(key!=null){
                genealogyGraphHashMap.put(key,graph);
            }else {
                return false;
            }
        }
        return  true;
    }

    /**
     * удаление дерева
     * @param graph удаляемое дерево
     * @return результат выполнения
     */
    public boolean removeGenealogyGraph(GenealogyGraph graph){
        if(genealogyGraphHashMap.containsValue(graph)){
            String key=getKeyByValue(genealogyGraphHashMap,graph);
            if(key!=null){
                genealogyGraphHashMap.remove(key);
            }else {
                return false;
            }
        }
        return  true;
    }

}
