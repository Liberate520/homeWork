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

        System.out.print("\tИмя - "); String name = iScanner.next();
        while (!validLetter(name)) { 
            System.out.print("Некорректное имя. Попробуйте ещё раз.\n\tИмя - "); name = iScanner.next(); 
        }

        System.out.print("\tПол - "); String sex = iScanner.next();
        while (!validLetter(sex)) { 
            System.out.print("Некорректный тип пола. Попробуйте ещё раз.\n\tПол - "); sex = iScanner.next(); 
        }

        System.out.print("\tГод рождения - "); 
        while (!iScanner.hasNextInt()) {
            System.out.print("Нужно указать год рождения. Попробуйте ещё раз.\n\tГод рождения - "); 
        }
        Integer yearOfBithd = iScanner.nextInt();

        System.out.print("\tИмя отца (если не известно 'нет') - "); String father = iScanner.next();
        while (!validLetter(father)) { 
            System.out.print("Некорректное имя. Попробуйте ещё раз.\n\tИмя отца (если не известно 'нет') - "); father = iScanner.next(); 
        }

        System.out.print("\tИмя матери (если не известно 'нет') - "); String mother = iScanner.next();
        while (!validLetter(mother)) { 
            System.out.print("Некорректное имя. Попробуйте ещё раз.\n\tИмя матери (если не известно 'нет') - "); mother = iScanner.next(); 
        }
        System.out.println(presenter.addTreeElement(name, sex, yearOfBithd, father, mother));
    }

    private boolean validLetter(String text) {
        text.strip();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) return false;
        }
        return true;
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
