package ui;

import human.Gender;
import java.util.Scanner;

public class ConsoleWorkMenu extends ConsoleMenu implements ViewWorkMenu{

    private WorkMenu workMenu;

    public ConsoleWorkMenu(){
        scanner = new Scanner(System.in);
        start = true;
        workMenu = new WorkMenu(this);
    }

    @Override
    public void start() {
        while (start){
            printMenu();
            execute();
        }
    }

    @Override
    public void addHuman() {
        System.out.println("Введите Имя человека:");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию человека:");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения человека:");
        String birthday = scanner.nextLine();
        System.out.println("Введите пол человека (М или Ж):");
        Gender gender = getGender();
        System.out.println("Введите ID матери(если неизвестно введите 0):");
        int motherID = getPersonId();
        System.out.println("Введите ID отца(если неизвестно введите 0):");
        int fatherId = getPersonId();
        presenter.addHuman(firstName, lastName, birthday, gender, motherID, fatherId);
    }

    private int getPersonId() {
        int motherId;
        while (true){
            String text = scanner.nextLine();
            if (checkTextForInt(text)) {
                motherId = Integer.parseInt(text);
                return motherId;
            } else {
                inputError();
            }
        }
    }

    @Override
    public void findHumanById() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int id = Integer.parseInt(line);
            try {
                System.out.println(presenter.findHumanById(id));
            } catch (Exception e){
                    System.out.println("Такого человека нет в семейном дереве");
            }
        } else {
            inputError();
        }
    }

    @Override
    public void findHuman() {
        System.out.println("Найти человека:");
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите дату рождения");
        String birthday = scanner.nextLine();
        try {
            System.out.println(presenter.findHuman(firstName, lastName, birthday));
        } catch (Exception e){
            System.out.println("Такого человека нет в семейном дереве");
        }
    }

    @Override
    public void printTree() {
        presenter.getPeople();
    }


    public void printMenu() {
        System.out.println(workMenu.print());
    }

    public void execute() {
        String input = scanner.nextLine();
        if (checkTextForInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand, workMenu)){
                workMenu.execute(numCommand);
            }
        }
    }


    private Gender getGender(){
        while (true){
            String text = scanner.nextLine();
            if (text.toUpperCase().equals("М")){
                return Gender.Male;
            } else if (text.toUpperCase().equals("Ж")) {
                return Gender.Female;
            }
            inputError();
        }
    }
}
