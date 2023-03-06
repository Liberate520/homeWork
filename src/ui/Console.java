package ui;

import api.AddFieldResult;
import api.Gender;
import presenter.Presenter;
import ui.commands.Option;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static api.Gender.Female;
import static api.Gender.Male;

public class Console implements View
{
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;
    public Console()
    {
        //scanner = new Scanner(System.in);
    }
    public void start() throws IOException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);

        printHello();
        work = true;

        while (work)
        {
            printInfo();

            String command = scanner.nextLine();
            if (checkInput(command))
            {
                menu.execute(Integer.parseInt(command));
            }
            else
            {
                System.out.println("Ошибка ввода!\n");
            }
        }
    }
    private boolean checkInput(String text)
    {
        return text.matches("[1-9]+");
    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
    private void printHello()
    {
        System.out.println("Вас приветствует электронная версия династии Романовых.");
    }

    private void printInfo()
    {
        System.out.printf("\nВыберите элемент меню:\n");
        System.out.println(menu.printMenu());
        System.out.printf("> ");
    }

    public void consoleExit()
    {
        work = false;
    }

    public void consolePrintTree()
    {
        String answer = "";
        answer = presenter.printTree();
        print(answer);
    }

    public void consoleSaveTree() throws IOException {
        String answer = "";
        answer = presenter.saveTreeToFile();
        print(answer);
    }

    public void consoleSortTreeByName() {
        String answer = "";
        answer = presenter.sortTreeByName();
        print(answer);
    }

    public void consoleSortTreeByDate() {
        String answer = "";
        answer = presenter.sortTreeByDate();
        print(answer);
    }

    public void consoleFindPerson()
    {
        String name = "";
        System.out.printf("Введите данные для поиска\n\t\t> ");

        String answer = "";
        answer = presenter.findPerson(scanner.nextLine());
        print(answer);
    }

    public void consoleAddPerson()//consoleAddPersonByName()
    {
        List<String> infoString = new ArrayList<>();
        infoString.add("Введите 0/1 - являлся ли человек правящим монархом: \n> ");
        infoString.add("Введите Имя: \n> ");
        infoString.add("Введите Отчество: \n> ");
        infoString.add("Введите Фамилию: \n> ");
        infoString.add("Введите пол (М/Ж): \n> ");
        infoString.add("Введите год рождения: \n> ");
        infoString.add("Введите год смерти: \n> ");
        infoString.add("Введите порядок правления: \n> ");
        infoString.add("Введите год начала правления: \n> ");
        infoString.add("Введите год окончания правления: \n> ");
        infoString.add("Введите имя супруга/супруги: \n> ");
        infoString.add("Введите имя отца: \n> ");
        infoString.add("Введите имя матери: \n> ");

        api.AddFieldResult result = api.AddFieldResult.Ok;
        int i = 0;
        int repeatCounter = 0;
        String line = "";
        while ((result != api.AddFieldResult.Finish) & (repeatCounter<3))
        {
            System.out.printf(infoString.get(i));
            line = scanner.nextLine();

            result = (api.AddFieldResult)presenter.addFieldsOfPerson((Object) line);

            if (result == api.AddFieldResult.Error)
            {
                repeatCounter++;
            }
            else if (result == AddFieldResult.Ok)
            {
                repeatCounter = 0;
                i++;
            }
        }
    }

    public void consoleAddPerson1()
    {
        System.out.printf("Введите 0/1 - являлся ли человек правящим монархом: \n> ");
        Integer indicator = Integer.parseInt(scanner.nextLine());
        boolean isTsar = false;
        if (indicator > 0)
        {
            isTsar = true;
        }
        else
        {
            isTsar = false;
        }

        String name = "";
        System.out.printf("Введите Имя: \n> ");
        name = scanner.nextLine();

        String middleName = "";
        System.out.printf("Введите Отчество: \n> ");
        middleName = scanner.nextLine();

        String surname = "";
        System.out.printf("Введите Фамилию: \n> ");
        surname = scanner.nextLine();

        String genderStr = "";
        System.out.printf("Введите пол (М/Ж): \n> ");
        genderStr = scanner.nextLine();
        Gender gender;
        if (genderStr.equals('М'))
        {
            gender = Male;
        }
        else
        {
            gender = Female;
        }

        System.out.printf("Введите год рождения: \n> ");
        Integer yearOfBirth = Integer.parseInt(scanner.nextLine());

        System.out.printf("Введите год смерти: \n> ");
        Integer yearOfDeath = Integer.parseInt(scanner.nextLine());

        Integer leaderNumber = 0;
        Integer yearOfReignStart = 0;
        Integer yearOfReignStop = 0;
        if (isTsar == true)
        {
            System.out.printf("Введите порядок правления: \n> ");
            leaderNumber = Integer.parseInt(scanner.nextLine());

            System.out.printf("Введите год начала правления: \n> ");
            yearOfReignStart = Integer.parseInt(scanner.nextLine());

            System.out.printf("Введите год окончания правления: \n> ");
            yearOfReignStop = Integer.parseInt(scanner.nextLine());
        }

        String spouse = "";
        System.out.printf("Введите имя супруга/супруги: \n> ");
        spouse = (scanner.nextLine());

        String father = "";
        System.out.printf("Введите имя отца: \n> ");
        father = (scanner.nextLine());

        String mother = "";
        System.out.printf("Введите имя матери: \n> ");
        mother = (scanner.nextLine());

        String answer = "";
        answer = presenter.addPerson(
                 isTsar,
                 name,
                 middleName,
                 surname,
                 gender,
                 yearOfBirth,
                 yearOfDeath,
                 leaderNumber,
                 yearOfReignStart,
                 yearOfReignStop,
                 spouse,
                 father,
                 mother
                );
        print(answer);
    }

    public void print(String text) {
        System.out.printf("%s",text);
    }
}
