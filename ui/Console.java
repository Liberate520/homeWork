package ui;

import commands.*;
import model.Calendar;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    // private Calendar calendarList;
    private Presenter presenter;
    List<Commands> commandsList;
    private Scanner scanner;

    public Console(Presenter presenter) {
        this.presenter = presenter;
        // this.calendarList = calendarList;
        commandsList = new ArrayList<>();
        presenter.setConsole(this);
    }

    // public Calendar getCalendar() {
    //     return calendarList;
    // }
    
    public Calendar getCalendar() {
        return presenter.getCalendar();
    }


    public Presenter getPresenter() {
        return presenter;
    }

    public void start() {

        commandsList.add(new Read(this));
        commandsList.add(new GetCalendar(this));
        commandsList.add(new GetDayRecords(this));
        commandsList.add(new AddRecord(this));
        commandsList.add(new Save(this));
        commandsList.add(new Exit(this));
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Выберите действие:");
            for (int i = 0; i < commandsList.size(); i++) {
                System.out.println(i + 1 + " - " + commandsList.get(i).description());
            }
            System.out.print(":");
            String str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) & (choice <= commandsList.size())) {
                    commandsList.get(Integer.parseInt(str) - 1).execute();
                } else {
                    System.out.println("некорректный ввод");
                }
            } catch (NumberFormatException e) {
                System.out.println("некорректный ввод");
            }
        }
    }

    public void printCalendarEntry(Calendar diary) {
        System.out.println(diary);
    }

    public void printDataDay(LocalDate data) {
        if (getCalendar().getBaseCalendar().size() > 0) {
            System.out.printf("Все записи %s на дату:\n", data);
            System.out.println(getCalendar().getDayRecords(data));
        } else {
            System.out.printf("На   %s записи отсутствуют.\n", data);
        }
    }

    public String getRecord() {
        scanner = new Scanner(System.in);
        System.out.println("Введите текст записи");
        String inText = scanner.next();
        return inText;
    }

    public LocalDate getData() {
        scanner = new Scanner(System.in);
        System.out.println("Введите год");
        int yearInput = scanner.nextInt();
        System.out.println("Введите месяц (1-12)");
        int monthInput = scanner.nextInt();
        System.out.println("Введите день (1-31)");
        int dayInput = scanner.nextInt();
        LocalDate inData = LocalDate.of(yearInput, monthInput, dayInput);
        return inData;
    }


}
