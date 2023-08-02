package View.tests;

import View.View;
import View.MainMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class TestForUI implements Test {
    private View view;
    private Scanner scanner;
    private MainMenu menu;

    public TestForUI(View view, MainMenu menu) {
        this.view = view;
        scanner = new Scanner(System.in);
        this.menu = menu;
    }

    public String menuTest(String choice) {
        if (!(testInt(choice))) {
            view.printAnswer(view.error());
            return null;
        }
        int check = Integer.parseInt(choice);
        if (!((check > 0) && (check <= menu.getSize()))) {
            view.printAnswer(view.error());
            return null;
        }
        return choice;
    }

    public boolean testInt(String choice) {
        if (choice == null) {
            view.printAnswer(view.error());
            return false;
        }
        int length = choice.length();
        if (length == 0) {
            view.printAnswer(view.error());
            return false;
        }
        int i;
        if (choice.charAt(0) == '-') {
            view.printAnswer(view.error());
            return false;
        }
        for (i = 0; i < length; i++) {
            char c = choice.charAt(i);
            if (c < '0' || c > '9') {
                view.printAnswer(view.error());
                return false;
            }
        }
        return true;
    }

    @Override
    public int testYear(String yearStr) {
        while (!(testInt(yearStr))) {
            yearStr = scanner.nextLine();
        }
        int year = Integer.parseInt(yearStr);
        while (!((year > -1) && (year <= LocalDate.now().getYear()))) {
            System.out.println("Неверный год, укажите снова.");
            yearStr = scanner.nextLine();
            while (!(testInt(yearStr))) {
                yearStr = scanner.nextLine();
            }
            year = Integer.parseInt(yearStr);
        }
        return year;
    }

    @Override
    public int testMonth(String monthStr) {
        while (!(testInt(monthStr))) {
            monthStr = scanner.nextLine();
        }
        int month = Integer.parseInt(monthStr);
        while (!((month > 0) && (month < 13))) {
            System.out.println("Неверный месяц, укажите снова: ");
            monthStr = scanner.nextLine();
            while (!(testInt(monthStr))) {
                monthStr = scanner.nextLine();
            }
            month = Integer.parseInt(monthStr);
        }
        return month;
    }

    @Override
    public int testDay(String dayStr) {
        while (!(testInt(dayStr))) {
            dayStr = scanner.nextLine();
        }
        int day = Integer.parseInt(dayStr);
        while (!((day > 0) && (day <= 30))) {
            System.out.println("Неверный день, укажите снова.");
            dayStr = scanner.nextLine();
            while (!(testInt(dayStr))) {
                dayStr = scanner.nextLine();
            }
            day = Integer.parseInt(dayStr);
        }
        return day;
    }
}
