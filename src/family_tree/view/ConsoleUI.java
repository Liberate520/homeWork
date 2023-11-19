package family_tree.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import family_tree.model.human.types_enum.Gender;
import family_tree.presenter.Presenter;

public class ConsoleUI implements View, Serializable{
    //private transient Scanner scanner;
    private Presenter presenter;
    private boolean inProgress;
    private MainMenu menu;

    public ConsoleUI() {
        //scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        inProgress = false;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Создайте дерево!");
        inProgress = true;
        while(inProgress)
        {
            printMenu();
            scanMenu();
        }
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }
    
    private void printMenu()
    {
        System.out.println(menu.print());
    }

    private void scanMenu()
    {
        Scanner scanner = new Scanner(System.in);
        String choiceStr = "";
        choiceStr = scanner.nextLine();
        if(checkTextForInt(choiceStr))
        {
            int choice = Integer.parseInt(choiceStr);
            if(checkCommandList(choice))
            {
                menu.execute(choice);
            }
        }

    }

    public void addToTree()
    {
        Scanner scanner = new Scanner(System.in);
        Gender gender = Gender.Male;
        LocalDate dateBirth = null;
        LocalDate dateDead = null;

        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения в формате (yyyy-MMM-dd)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        try {
            
            dateBirth = LocalDate.from(formatter.ISO_LOCAL_DATE.parse(scanner.nextLine()));

            System.out.println("Введите дату смерти в формате (yyyy-MMM-dd). Если жив ничего не пишите.");
            String userInput = scanner.nextLine();
            if(userInput.length() == 0)
            {
                dateDead = null;
            }
            else
            {
                System.out.println(userInput.length());
                dateDead = LocalDate.from(formatter.ISO_LOCAL_DATE.parse(userInput));
            }

        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println("пол 1. Мужской /n 2. Женский");
        int choiceGen = Integer.parseInt(scanner.nextLine());
        System.out.println(choiceGen);
        if(choiceGen == 1)
        {
            gender = Gender.Male;
        }
        else if (choiceGen == 2)
        {
            gender = Gender.Female;
        }
        else
        {
            System.out.println("Ошибка ввода");
        }

        presenter.addToTree(name, dateBirth, dateDead, gender);
    }

    public void addParents()
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int motherIndex = 0;
        int fatherIndex = 0;
        int childIndex = 0;
        System.out.println("Выберите кому будем добавлять родителей");
        getFamilyTreeInfo();
        String сhildIndexStr = scanner.nextLine();

        if(checkTextForInt(сhildIndexStr))
        {
            choice = Integer.parseInt(сhildIndexStr);
            if(checkFamilyList(choice))
            {
                childIndex = choice;
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }

        System.out.println("Выберите мать. Если не известна, то ничего не вводите");
        getFamilyTreeInfo();
        String motherIndexStr = scanner.nextLine();

        if(motherIndexStr.length() == 0)
        {
            motherIndex = 0;
        }
        else if(checkTextForInt(motherIndexStr))
        {
            choice = Integer.parseInt(motherIndexStr);
            if(checkFamilyList(choice))
            {
                motherIndex = choice;
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }

        System.out.println("Выберите отца");
        getFamilyTreeInfo();
        String fatherIndexStr = scanner.nextLine();

        if(checkTextForInt(fatherIndexStr))
        {
            choice = Integer.parseInt(fatherIndexStr);
            if(checkFamilyList(choice))
            {
                fatherIndex = choice;
            }
            else if(motherIndexStr.length() == 0)
            {
                fatherIndex = 0;
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }

        addParentToChild(motherIndex - 1, fatherIndex - 1, childIndex - 1);
    }

    private void addParentToChild(int mothers_index, int fathers_index, int child_index)
    {
        presenter.addParentToChild(mothers_index, fathers_index, child_index);
    }

    public void sortByName()
    {
        presenter.sortByName();
    }

    public void sortByAge()
    {
        presenter.sortByAge();
    }
    
    public void getFamilyTreeInfo()
    {
        presenter.getFamilyTreeHumansListInfo();
    }

    public void saveAndExit ()
    {
        inProgress = false;
    }

    private void error() {
        System.out.println("Введено неверное значение!");
    }

    private boolean checkCommandList(int itemNum)
    {
        if (itemNum <= menu.size()){
            return true;
        } else {
            error();
            return false;
        }
    }

    private boolean checkFamilyList(int itemNum)
    {
        if (itemNum <= presenter.getFamilyListSize()){
            return true;
        } else {
            error();
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            error();
            return false;
        }
    }
}
