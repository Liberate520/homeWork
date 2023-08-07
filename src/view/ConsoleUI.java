package view;


import model.Service.ServiceTree;
import model.human.Gender;
import model.human.Human;
import presenter.Presenter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "WRONG DATA";
    private static final String INPUT_SUCCESS = "ADDING SUCCESSFULLY";
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        System.out.println("**********************************");
        System.out.println("Welcome to GenealogicalTree app");
        System.out.println("**********************************");

        while (work) {
            System.out.println(menu.menu());
            System.out.print("You should choose the action: ");
            String choice = scanner.nextLine();

            try {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt <= menu.getSize()) menu.execute(choiceInt);
                else errorInput();
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
            }

        }

    }

    public void finish() {
        System.out.println("*********");
        System.out.println("Goodbye!");
        System.out.println("*********");
        work = false;
    }

    public void errorInput() {
        System.out.println("You have entered the wrong number! Try again!");
    }

    public void sortByAge() {
        presenter.sortByAge();
        presenter.getInfo();

    }

    public void sortByName() {
        presenter.sortByName();
        presenter.getInfo();
    }

    public void getFamilyInfo() {
        presenter.getInfo();
    }

    public void addPerson() {
        //NAME
        System.out.print("Insert name: ");
        String name = scanner.nextLine();

        //LAST NAME
        System.out.print("Insert last name: ");
        String lastName = scanner.nextLine();


        //GENDER
        Gender gender = null;
        System.out.print("Insert gender of person(male or female): ");
        String genderString = scanner.nextLine();
        while (!checkGender(genderString)) {
            System.out.println("Please, reenter!");
            genderString = scanner.nextLine();
        }
        Gender[] genders = Gender.values();


        for (int i = 0; i < genders.length; i++) {
            String genderCheck = genders[i].toString();
            if (genderCheck.equalsIgnoreCase(genderString)) {
                gender = genders[i];
            }

        }


        //BIRTH DATE
        LocalDate birthDate = null;
        System.out.println("Insert date of birth in format dd.mm.yyyy: ");
        String birthdateString = scanner.nextLine();
        SimpleDateFormat formatBirth = new SimpleDateFormat();
        formatBirth.applyPattern("dd.MM.yyyy");
        try {
            Date birthdate = formatBirth.parse(birthdateString);
            birthDate = convertToLocalDate(birthdate);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //DEATH DATE
        LocalDate deathDate = null;

        System.out.println("Insert date of date in format dd.mm.yyyy\nPrint null if person is alive: ");
        String deathdateString = scanner.nextLine();
        SimpleDateFormat formatDeath = new SimpleDateFormat();
        formatDeath.applyPattern("dd.MM.yyyy");
        try {
            if (!deathdateString.equals("null")) {
                Date deathdate = formatDeath.parse(birthdateString);
                deathDate = convertToLocalDate(deathdate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Human mother = null;
        Human father = null;
        Human spouse = null;
        List<Human> children = null;


        presenter.addHuman(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
        printAnswer(INPUT_SUCCESS);

    }

    private boolean checkGender(String genderString) {
        return genderString.equalsIgnoreCase("male") || genderString.equalsIgnoreCase("female");
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public void addSpouse() {
        System.out.println("Please, enter ID of married persons: ");
        System.out.println("First member: ");
        int idSpouse1 = scanner.nextInt();
        System.out.println();
        System.out.println("Second member: ");
        int idSpouse2 = scanner.nextInt();

        if (idSpouse2 <= presenter.getFamilySize() && idSpouse1 <= presenter.getFamilySize()) {
            presenter.setSpouseTogether(idSpouse1, idSpouse2);
            printAnswer(INPUT_SUCCESS);

        } else {
            System.out.println("You have entered wrong numbers!");
        }
    }

    public void addChildren() {
        System.out.println("Please, enter ID of parent: ");
        int idParent = scanner.nextInt();
        System.out.println();
        System.out.println("Please, enter ID of child: ");
        int idChild = scanner.nextInt();
        if (idChild <= presenter.getFamilySize() && idParent <= presenter.getFamilySize()) {
            presenter.setChild(idParent, idChild);
            printAnswer(INPUT_SUCCESS);
        } else printAnswer(INPUT_ERROR);
    }

        public void saveFile () throws IOException {
            FileOutputStream file = new FileOutputStream("familytree.out");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(presenter.getTree());

            out.close();
            file.close();
        }

        public void readFile () {
            try {
                FileInputStream file = new FileInputStream("familytree.out");
                ObjectInputStream in = new ObjectInputStream(file);
                ServiceTree object = (ServiceTree) in.readObject();
                presenter.setServiceTree(object);

                in.close();
                file.close();

            } catch (IOException ex) {
                System.out.println("IOException is caught");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException is caught");
            }
        }
    }

