package HomeWork5.ui;

import HomeWork5.presenter.Presenter;
import java.util.Scanner;
import HomeWork5.model.FamilyFree;
import HomeWork5.model.Human;

public class Console implements View
{
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;

    @Override
    public void start() 
    {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go)
        {
            header();
            menuUi();
            System.out.print("Выберите пункт Меню -> ");
            String command = scan.nextLine();
            if (checkInput(command))
            {
                menu.execute(Integer.parseInt(command));
            } 
            else 
            {
                System.out.println("Введите число!");
            }
        }
    }


    private void header() 
    {
        System.out.println("\n" + 
        " В данной программе доступны поиск, \n добавление и вывод семейного древа");
    }

    private void menuUi()
    {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew()
    {
        System.out.print("Введите имя-> ");
        String name = scan();
        System.out.print("Введите пол(муж./жен.)-> ");
        String sex = scan();
        System.out.print("Введите возраст-> ");
        int age = Integer.parseInt(scan());
        presenter.addHumanNew(name, sex, age);
    }

    public void familyPrint()
    {
        presenter.familyPrint();
    }

    public void humanSearch()
    {
        System.out.print("Введите имя человека для поиска-> ");
        String name =  scan();
        presenter.humanSearch(name);
    }

    public void end()
    {
        go = false;
        System.out.println("Спасибо что пользуетесь нашим сервисом :D");
    }

    @Override
    public void setPresenter(Presenter presenter) 
    {
        this.presenter = presenter;
    }

    @Override
    public String scan() 
    {
        scan = new Scanner(System.in, "Cp866");
        return scan.nextLine();
    }

    private boolean checkInput(String text)
    {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text)
    {
        System.out.println(text);
    }

    @Override
    public void print(Human chelovek)
    {
        System.out.println(chelovek);
    }

    @Override
    public void print(FamilyFree<Human> FamilyFree) 
    {
        System.out.println(FamilyFree);
    }


    public void loadFamily() {
    }


    public void saveFamily() {
    }


    public void sortFamily() {
    }
}
