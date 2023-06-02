package ui;

import java.util.Scanner;


import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public int id;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }


    @Override
    public void print(String text) {
        System.out.println(text);

    }
    
    @Override
    public void start() {
        System.out.println("Привет!");
        while (work) {
            presenter.readFile();
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            mainMenu.execute(numCommand);
        }
        
    }

    public void finish() {
        System.out.println("До скорых встреч!");
        work = false;
    }
    
    public void getInfo() {
        presenter.getInfo();
    }
    
    public void addHuman() {
        //System.out.println("Введите id");
        
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате дд.мм.гггг");
        String dateOfBirth = scanner.nextLine();
        presenter.addHuman(++id, name, surname, dateOfBirth, null);

    }
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void saveFile() {
        presenter.saveFile();
    }


    @Override
    public void readFile() {
        presenter.readFile();
    }






}
