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
        presenter.AddHumanNew();
    }

    public void end()
    {
        go = false;
        System.out.println("Спасибо что пользуетесь нашим сервисом :D");
    }

    public void familyPrint()
    {
        presenter.familyPrint();
    }

    public void humanSearch()
    {
        presenter.humanSearch();
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
}
