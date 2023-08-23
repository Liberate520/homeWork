package View.tests;

import View.View;
import View.MainMenu;
import View.TextInput;

import java.time.LocalDate;
import java.util.Scanner;

public class TestForUI implements Test {
    private final View view;
    private final Scanner scanner;
    private final MainMenu menu;
    private final TextInput textInput;
    public TestForUI(View view, MainMenu menu, TextInput textInput) {
        this.view = view;
        scanner = new Scanner(System.in);
        this.menu = menu;
        this.textInput = textInput;
    }

    public String menuTest(String choice) {
        if (!(testInt(choice))) {
            view.printAnswer(textInput.getAnswer("errorInput"));
            return null;
        }
        int check = Integer.parseInt(choice);
        if (!((check > 0) && (check <= menu.getSize()))) {
            view.printAnswer(textInput.getAnswer("errorInput"));
            return null;
        }
        return choice;
    }

    public boolean testInt(String choice) {
        if (choice == null) {
            view.printAnswer(textInput.getAnswer("errorInput"));
            return false;
        }
        int length = choice.length();
        if (length == 0) {
            view.printAnswer(textInput.getAnswer("errorInput"));
            return false;
        }
        int i;
        if (choice.charAt(0) == '-') {
            view.printAnswer(textInput.getAnswer("errorInput"));
            return false;
        }
        for (i = 0; i < length; i++) {
            char c = choice.charAt(i);
            if (c < '0' || c > '9') {
                view.printAnswer(textInput.getAnswer("errorInput"));
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
            view.printAnswer(textInput.getAnswer("errorSetYear"));
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
            view.printAnswer(textInput.getAnswer("errorSetMonth"));
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
            view.printAnswer(textInput.getAnswer("errorSetDay"));
            dayStr = scanner.nextLine();
            while (!(testInt(dayStr))) {
                dayStr = scanner.nextLine();
            }
            day = Integer.parseInt(dayStr);
        }
        return day;
    }
}
