package view;

import java.time.LocalDate;
import java.util.Scanner;
import Presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private LocalDate dataOfBirth;
    private LocalDate dataOfDeath;
    private boolean work;
    private boolean errorFlag;
    private MainMenu menu;
    private int rewInt;
    private int dataInt;
    private int mounthInt;
    private int kinshipInt;
    private int addIdInt;
    private int fromIdInt;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in, "Cp866");
        work = true;
        errorFlag = true;
        menu = new MainMenu(this);
        dataInt = -1;
        mounthInt = -1;

        kinshipInt = -1;

    }

    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                menu.execute(choiceInt);
            } catch (Exception e) {
                errorInput();
            }

        }

    }

    public void getInfoHumans() {
        presenter.HumanGetListInfo();
    }

    public void addKinship() {
        kinshipInt = -1;
        addIdInt = -1;
        fromIdInt = -1;
        errorFlag = true;
        while (errorFlag) {
            System.out.println("Укажите родство 1 или 2");
            getInfoHumans();
            System.out.println("1. родитель");
            System.out.println("2. ребенок ");
            String kinshipStr = scanner.nextLine();
            try {
                kinshipInt = Integer.parseInt(kinshipStr);
                if (kinshipInt == 1 || kinshipInt == 2) {

                } else {
                    errorInput();
                }

                System.out.println("Кого добавить, укажите ID");
                String addIdStr = scanner.nextLine();
                addIdInt = Integer.parseInt(addIdStr);
                System.out.println("Кому добавить, укажите ID");
                String fromIdStr = scanner.nextLine();
                fromIdInt = Integer.parseInt(fromIdStr);
                errorFlag = false;
            } catch (Exception e) {
                errorInput();
            }
        }
        presenter.addKinshp(addIdInt, kinshipInt, fromIdInt);

    }

    public void addHuman() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        errorFlag = true;
        while (errorFlag) {
            System.out.println("Укажите пол 1 или 2 ");
            System.out.println("1. мужской");
            System.out.println("2. женский ");
            String rew = scanner.nextLine();
            try {
                this.rewInt = Integer.parseInt(rew);
                if (this.rewInt == 1 || this.rewInt == 2) {
                    errorFlag = false;
                } else {
                    errorInput();
                }
            } catch (Exception e) {
                errorInput();
            }

        }
        errorFlag = true;
        dataInt = -1;
        mounthInt = -1;

        while (errorFlag) {

            System.out.println("Укажите дату рождения ");
            try {
                while (dataInt < 1 || dataInt > 31) {
                    System.out.print("Дата: ");
                    String data = scanner.nextLine();
                    dataInt = Integer.parseInt(data);
                    if (dataInt < 1 || dataInt > 31) {
                        errorInput();
                    }
                }
                while (mounthInt < 1 || mounthInt > 12) {
                    System.out.print("Месяц: ");
                    String mounth = scanner.nextLine();
                    mounthInt = Integer.parseInt(mounth);
                    if (mounthInt < 1 || mounthInt > 12) {
                        errorInput();
                    }
                }
                System.out.print("Год: ");
                String year = scanner.nextLine();
                int yearInt = Integer.parseInt(year);

                dataOfBirth = LocalDate.of(yearInt, mounthInt, dataInt);
                errorFlag = false;
            } catch (Exception e) {
                errorInput();
            }
        }
        // String dataDeath = scanner.nextLine();
        // try {
        // this.dataOfDeath = LocalDate.parse(dataDeath);
        // } catch (Exception e) {
        // System.out.println("Ошибка");
        // }

        presenter.addHuman(name, rewInt, dataOfBirth, dataOfDeath);

    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void SortByAge() {
        presenter.sortByAge();
        getInfoHumans();
    }

    public void sortById() {
        presenter.sortById();
        getInfoHumans();
    }

    public void sortByName() {
        presenter.sortByName();
        getInfoHumans();
    }

    public void finish() {

        scanner.close();
        presenter.saveHumanTree();
        work = false;
    }

    private void errorInput() {
        System.out.println("Введено некорректное значение!\n" +
                "Введите заново");
    }

    public void LoadFile() {

        presenter.LoadFile();

    }

    public void DelHuman() {
        System.out.println("Введите ID человека");
        String idStr=scanner.nextLine();
        int idInt=Integer.parseInt(idStr);
        presenter.delHuman(idInt);
        
    }
    

    // private int convertToInt(){
    //     String valueStr=scanner.nextLine();
    //     int valueInt=Integer.parseInt(valueStr);
    //     return valueInt;
    // }
}
