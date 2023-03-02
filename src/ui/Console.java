package ui;

import java.io.IOException;
import java.util.Scanner;
import presenter.Presenter;
import ui.allMenuList.FileHandlerMenu;
import ui.allMenuList.MainMenu;
import ui.allMenuList.SecondaryMenu;
import ui.allMenuList.SortMenu;

public class Console implements View{
    private Scanner iScanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        iScanner = new Scanner(System.in, "Cp866");
        menu = new Menu(this);
        greeting();
        work = true;
        while(work) {
            Menu();
            String command = iScanner.next();
            if (checkInput(command)) { menu.execute(Integer.parseInt(command)); }
        }
    }

    private boolean checkInput(String text) {
        Integer intValue;
        if(text == null || text.equals("")) { 
            System.out.println("Строка пустая."); 
            return false; 
        }
        try { 
            intValue = Integer.parseInt(text); 
            return true; 
        } catch (NumberFormatException e) { System.out.println("\nВы ввели неизвестную команду. Введите число из списка меню.\n"); } 
        return false;
    }

    public void greeting() {
        System.out.println("    *****                                                     *****\n" +
                           "  ****|****                                                 ****|****\n" +
                           " ***\\*|*/***   Добро пожаловать в генеалогическое древо!   ***\\*|*/***\n" +
                           "  ***\\|/***                                                 ***\\|/***\n" +
                           "     *|*                                                       *|*\n" +
                           "     _|_                                                       _|_\n");
    }

    private void Menu() {
        System.out.println("==========  Меню  ==========");
        System.out.print(menu.printMenu());
        System.out.println("============================");
        System.out.print("Выберите необходимы пункт меню: ");
    }
  
    // begin StartMenu
    public void createNewTree() { 
        System.out.println();
        System.out.println(presenter.createNewTree()); 
        returnMainMenu();
    }

    public void loadTree() throws ClassNotFoundException, IOException { 
        System.out.println(presenter.loadTree()); 
        returnMainMenu();
    }

    public void endWork() { work = false; }
    // end StartMenu

    // begin MainMenu
    public void addTreeElement() {
        StringBuilder stbuild = new StringBuilder();
        System.out.print("\nЗаполните поля:\n");
        System.out.print("\tИмя - "); stbuild.append(iScanner.next());
        System.out.print("\tПол - "); stbuild.append(iScanner.next());
        System.out.print("\tГод рождения - "); stbuild.append(iScanner.next());
        System.out.print("\tИмя отца (если не известно 'нет') - "); stbuild.append(iScanner.next());
        System.out.print("\tИмя матери (если не известно 'нет') - "); stbuild.append(iScanner.next());
        System.out.println(presenter.addTreeElement(stbuild));
    }

    public void showTree() { System.out.print(presenter.showTree()); }

    public void saveTree() { System.out.print(presenter.saveTree()); }

    public void findTreeElement() {
        System.out.print("\nДля поиска введите имя:\n");
        System.out.print("\tИмя - ");
        System.out.println(presenter.findTreeElement(iScanner.next()));
        menu.setMenu(new SecondaryMenu(this));
    }

    public void sortTree() { menu.setMenu(new SortMenu(this));}

    public void importTree() { menu.setMenu(new FileHandlerMenu(this)); }
    // public void endWork() { work = false; } - StartMenu
    // end MainMenu

    // begin SecondaryMenu
    public void showChildrens() { System.out.println("Дети:\n" + presenter.showChildrens()); }
    
    public void showFather() { System.out.println("Отец: " + presenter.showFather()); }
    
    public void showMother() { System.out.println("Мать: " + presenter.showMother()); }
    
    public void returnMainMenu() { menu.setMenu(new MainMenu(this)); }
    // end SecondaryMenu

    // begin SortMenu
    public void sortByName() { 
        System.out.println(presenter.sortByName()); 
        returnMainMenu();
    }

    public void sortByYearOfBirth() { 
        System.out.println(presenter.sortByYearOfBirth()); 
        returnMainMenu();
    }
    // end SortMenu

    // begin FileHandlerMenu
    public void formatToTxt() {
        System.out.print("\nВведите имя файла - "); String file_name = iScanner.next();
        System.out.println(presenter.formatToTxt(file_name + ".txt"));
        returnMainMenu();
    }
    // end FileHandlerMenu
}
