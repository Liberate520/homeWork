package ui;

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
    public void start() {
        iScanner = new Scanner(System.in, "Cp866");
        menu = new Menu(this);
        greeting();
        work = true;
        while(work) {
            menu();
            String command = iScanner.nextLine();
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

    private void greeting() {
        System.out.println("    *****                                                     *****\n" +
                           "  ****|****                                                 ****|****\n" +
                           " ***\\*|*/***   Добро пожаловать в генеалогическое древо!   ***\\*|*/***\n" +
                           "  ***\\|/***                                                 ***\\|/***\n" +
                           "     *|*                                                       *|*\n" +
                           "     _|_                                                       _|_\n");
    }

    private void menu() {
        System.out.println();
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

    public void loadTree() { 
        System.out.println(presenter.loadTree()); 
        returnMainMenu();
    }

    public void endWork() { work = false; }
    // end StartMenu

    // begin MainMenu
    public void addTreeElement() {
        System.out.print("\nЗаполните поля:\n");

        System.out.print("\tИмя - "); String name = iScanner.nextLine();
        while (!validLetter(name)) { 
            System.out.print("! Некорректное имя. Попробуйте ещё раз.\n\tИмя - "); name = iScanner.nextLine(); 
        }
        System.out.print("\tПол - "); String sex = iScanner.nextLine();
        while (!validLetter(sex)) { 
            System.out.print("! Некорректный тип пола. Попробуйте ещё раз.\n\tПол - "); sex = iScanner.nextLine(); 
        }
        System.out.print("\tГод рождения - "); String yearOfBirth = iScanner.nextLine();
        while (!validDigit(yearOfBirth)) {
            System.out.print("! Нужно указать год рождения. Попробуйте ещё раз.\n\tГод рождения - "); yearOfBirth = iScanner.nextLine();
        }
        System.out.print("* Введите \"нет\" если имя неизвестно.\n\tИмя отца - "); String father = iScanner.nextLine();
        while (!validLetter(father)) { 
            System.out.print("! Некорректное имя. Попробуйте ещё раз.\n* Введите \"нет\" если имя неизвестно.\n\tИмя отца - "); father = iScanner.nextLine(); 
        }
        System.out.print("* Введите \"нет\" если имя неизвестно.\n\tИмя матери - "); String mother = iScanner.nextLine();
        while (!validLetter(mother)) { 
            System.out.print("! Некорректное имя. Попробуйте ещё раз.\n* Введите \"нет\" если имя неизвестно.\n\tИмя матери - "); mother = iScanner.nextLine(); 
        }
        System.out.println(presenter.addTreeElement(name, sex, yearOfBirth, father, mother));
    }

    private boolean validLetter(String text) {
        text = text.replace(" ", "");
        if (text == "") return false;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) return false;
        }
        return true;
    }

    private boolean validDigit(String text) {
        if (text == "") return false;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) return false;
        }
        return true;
    }
    
    public void showTree() { System.out.print("\n" + presenter.showTree()); }

    public void saveTree() { System.out.print("\n" + presenter.saveTree() + "\n"); }

    public void findTreeElement() {
        System.out.print("\nДля поиска введите имя:\n");
        System.out.print("\tИмя - ");
        System.out.println(presenter.findTreeElement(iScanner.nextLine()));
        menu.setMenu(new SecondaryMenu(this));
    }

    public void sortTree() { menu.setMenu(new SortMenu(this));}

    public void importTree() { menu.setMenu(new FileHandlerMenu(this)); }
    // public void endWork() { work = false; } - StartMenu
    // end MainMenu

    // begin SecondaryMenu
    public void showChildrens() { 
        System.out.println("\nДети:\n" + presenter.showChildrens()); 
        returnMainMenu();
    }
    
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
        System.out.print("\nВведите имя файла - "); String file_name = iScanner.nextLine();
        System.out.println(presenter.formatToTxt(file_name + ".txt"));
        returnMainMenu();
    }
    // end FileHandlerMenu
}
