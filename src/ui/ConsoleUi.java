package Seminar6.src.ui;

import Seminar6.src.presenter.Presenter;
import Seminar6.src.ui.commands.Commands;

import java.util.Scanner;

public class ConsoleUi implements View {
    private boolean signal;
    private Presenter presenter;
    private final Scanner scanner;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
    }

    public void launch() {
        signal = true;
        while (signal){
            Menu menu = new Menu();
            menu.menuCommand(this);
            menu.print();
            int num = CheckingInput.checkNumberOutOfRange(menu.getList().size());
            int number = CheckingInput.checkNumberSizeZero(num,sizeNotes());
            Commands vs = menu.fulFill(number-1);
            vs.execute();

        }

    }
    public  void addingNote(){
        System.out.println("Введите запись ");
        String str = scanner.nextLine();
        presenter.addNote(str);
        System.out.printf("Добавлена запись номер %s\n",
                presenter.printAllNotes().size());

    }
    public void printAllNotes(){
        System.out.printf("У вас %s записей:\n",
                presenter.printAllNotes().size());
        System.out.println("--------------------------------");
        for (int i = 0;i < presenter.printAllNotes().size();i++){
            System.out.printf("%s) %s\n",i+1,presenter.printAllNotes().get(i));
        }
    }

    public void delete(){
        printAllNotes();
        System.out.println("введите номер записи для удаления ");
        int number = check();
        presenter.deleteNote(number-1);
        System.out.printf("Запись номер %s удалена\n",number);
    }

    public  void changeNote(){
        printAllNotes();
        System.out.println("введите номер записи, " +
                "которую хотите отредактировать ");
        int number = check();
        String st = presenter.getNotes().getRandomNotes().get(number-1);
        System.out.printf("Сейчас здесь такая запись: %s\n",st);
        System.out.println("внесите изменения :");
        String string = scanner.nextLine();
        presenter.changeNote(number,string);
        System.out.printf("Запись номер %s изменена \n",number);

    }

    /*
    получение размера списка записей
     */
    public  int sizeNotes(){
        return  presenter.getNotes().getRandomNotes().size();
    }

    /*
    использование  принципа DRY
     */
    public int check(){
        int num = CheckingInput.checkNumberOutOfRange(sizeNotes());
        return CheckingInput.checkNumberSizeZero(num,sizeNotes());
    }

    public void finish(){
        signal = false;
        System.out.println("Работа программы закончена");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
