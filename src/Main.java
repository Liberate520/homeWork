package org.example;


import java.time.LocalDate;
import java.util.*;


public class Main
{
    public static void main( String[] args ) {
        ArrayList<Human> databaseOfRelatives = new ArrayList<>();   // База данных Human +++++++++++++++++++++++++++++++
        ArrayList<HumanConnections> databaseHC = new ArrayList<>(); // База данных HumanConnections ++++++++++++++++++++

        //--------------------------------------------------------------------------------------------------------------
        databaseOfRelatives.add(new Human("Демидович Павел Анатольевич", Gender.male, // Ввод некоторых данных
                LocalDate.of(1988, 8, 23)));
        databaseOfRelatives.add(new Human("Демидович Агата Павловна", Gender.female,
                LocalDate.of(2013, 9, 16)));
        databaseOfRelatives.add(new Human("Демидович Анатолий Афанасьевич", Gender.male,
                LocalDate.of(1955, 9, 28)));
        databaseOfRelatives.add(new Human("Демидович Галина Ивановна", Gender.female,
                LocalDate.of(1950, 9, 24)));
        databaseOfRelatives.add(new Human("Мордвинцева Александра Павловна", Gender.female,
                LocalDate.of(1925, 5, 1), LocalDate.of(1959, 3, 3)));
        databaseOfRelatives.add(new Human("Гулак Иван Васильевич", Gender.male));
        databaseOfRelatives.add(new Human("Демидович Анастасия Герасимовна", Gender.female));
        databaseOfRelatives.add(new Human("Демидович Афанасий Гаврилович", Gender.male));
        databaseOfRelatives.add(new Human("Балашенко Феодосия Ивановна"));
        //--------------------------------------------------------------------------------------------------------------
        for (Human databaseOfRelative : databaseOfRelatives) {   // Наполнение базы данных связей центральной личностью
            databaseHC.add(new HumanConnections(databaseOfRelative));
        }
        //--------------------------------------------------------------------------------------------------------------
        // Кнопки:
        Menu mainM = new Menu();
        mainM.setButtons(new HashMap<>(Map.of(
                1, "Вывод на экран",
                2, "Добавить человека",
                3, "Добавить/изменить данные",
                4, "Выход")));

        Menu mainM1 = new Menu();
        mainM1.setButtons(new HashMap<>(Map.of(
                1, "Печать выбранного человека",
                2, "Печать всего списка людей")));

        Menu mainM3 = new Menu();
        mainM3.setButtons(new HashMap<>(Map.of(
                1, "Изменить данные человека",
                2, "Изменить связи человека",
                3, "Вернуться в предыдущее меню")));

        Menu mainM31 = new Menu();
        mainM31.setButtons(new HashMap<>(Map.of(
                1, "Ф.И.О.",
                2, "ПОЛ",
                3, "ДАТУ РОЖДЕНИЯ",
                4, "ДОБАВИТЬ/РЕДАКТИРОВАТЬ ДАТУ СМЕРТИ",
                5, "Вернуться в предыдущее меню")));

        Menu mainM32 = new Menu();
        mainM32.setButtons(new HashMap<>(Map.of(
                1, "mother",
                2, "father",
                3, "children",
                4, "brothersAndSisters",
                5, "Вернуться в предыдущее меню")));
        //====================================================
        Menu messages = new Menu();
        messages.setButtons(new HashMap<>(Map.of(
                1, "*******ВЫБЕРЕТЕ ЧЕЛОВЕКА ИЗ СПИСКА*******\n",
                2, "*******ЧТО ВЫ ХОТИТЕ ДОБАВИТЬ/ИЗМЕНИТЬ ?*******\n",
                3, "***Введите Ф.И.О***",
                4, "*******ВЫБЕРЕТЕ ЦЕНТРАЛЬНУЮ ФИГУРУ ИЗ СПИСКА*******\n")));
        //====================================================

        // очищение консоли реализовать


        //------------------------------------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        while (!flag) {
            mainM.outputOfMenuButtons(mainM.getButtons()); // выводит меню в консоль
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {           // Печать
                    mainM1.outputOfMenuButtons(mainM1.getButtons());
                    input = scanner.nextLine();
                    if (input.equals("1")) {  //Печать выбранного человека
                        HumanConnections.printNameHumanConnect(databaseHC);
                        HumanConnections.SuperPrintHumanHC(databaseHC, Integer.parseInt(scanner.nextLine()) - 1);
                    } else {                     //Печать всего списка людей
                        Human.SuperPrintNameHuman(databaseOfRelatives);
                    }
                }
                case "2" ->     // Добавить человека
                        databaseOfRelatives.add(new Human(scanner));
                case "3" -> {    // Изменить данные человека/Изменить связи человека
                    boolean flag2 = false;
                    while (!flag2) {
                        mainM.outputOfMenuButtons(mainM3.getButtons());
                        input = scanner.nextLine();
                        if (input.equals("1")) {    // Изменить данные человека
                            messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(1)));
                            Human.printNameHuman(databaseOfRelatives); // вывод списка Human по именам
                            input = scanner.nextLine();  // выбор Human из списка

                            boolean flag3 = false;
                            while (!flag3) {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(2)));
                                Human.printHuman(databaseOfRelatives, Integer.parseInt(input) - 1);
                                mainM31.outputOfMenuButtons(mainM31.getButtons());
                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1 -> {
                                        messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(3)));
                                        databaseOfRelatives.get(Integer.parseInt(input) - 1).setName(scanner.nextLine());
                                    }
                                    case 2 -> databaseOfRelatives.get(Integer.parseInt(input) - 1).setGender(scanner);
                                    case 3 ->
                                            databaseOfRelatives.get(Integer.parseInt(input) - 1).setDateOfBirth(scanner);
                                    case 4 ->
                                            databaseOfRelatives.get(Integer.parseInt(input) - 1).setDateOfDeath(scanner);
                                    case 5 -> flag3 = true;
                                }
                            }
                        } else if (input.equals("2")) {            //Изменить связи человека
                            messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(4)));
                            HumanConnections.printNameHumanConnect(databaseHC); // вывод списка центральных фигур HC
                            input = scanner.nextLine();  // выбор Human из списка
                            boolean flag4 = false;
                            while (!flag4) {
                                messages.outputOfMessages(messages.getButtons(), new ArrayList<>(List.of(2)));
                                HumanConnections.printHumanHC(databaseHC, Integer.parseInt(input) - 1);
                                mainM32.outputOfMenuButtons(mainM32.getButtons());
                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1 -> databaseHC.get(Integer.parseInt(input) - 1).setMother(databaseOfRelatives,
                                            databaseHC, Integer.parseInt(input) - 1, scanner);
                                    case 2 -> databaseHC.get(Integer.parseInt(input) - 1).setFather(databaseOfRelatives,
                                            databaseHC, Integer.parseInt(input) - 1, scanner);
                                    case 3 ->
                                            databaseHC.get(Integer.parseInt(input) - 1).setChildren(databaseOfRelatives,
                                                    databaseHC, Integer.parseInt(input) - 1, scanner);
                                    case 4 ->
                                            databaseHC.get(Integer.parseInt(input) - 1).setBrothersAndSisters(databaseOfRelatives,
                                                    databaseHC, Integer.parseInt(input) - 1, scanner);
                                    case 5 -> flag4 = true;
                                }
                            }
                        } else {
                            flag2 = true;
                        }
                    }
                }
                case "4" ->   // Выход
                        flag = true;
            }
            }
        scanner.close();
        }
    }