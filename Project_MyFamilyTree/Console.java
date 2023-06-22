package Project_MyFamilyTree;

import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private String meaning;

    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
    }
    
    @Override
    public void print() {
        System.out.println(meaning);
    }
       

    @Override
    public void buttonStart() {
        System.out.println("(((Human - ID)))");
        while (work) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1){
                System.out.println("Введено неккоректное значение");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)){
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void finish() {
        System.out.println("Мы рады были с вами работать");
        work = false;
    }

    public void getNote(){
        System.out.println("Укажите событие");
        String event = scanner.nextLine();
        presenter.getNote(event);
    }

}


    

    
