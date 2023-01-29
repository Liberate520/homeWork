package Calendar.UI;

import Calendar.commands.*;
import Calendar.commands.Commands;
import Calendar.commands.SaveAndFinish;
import Calendar.model.Day;
import Calendar.model.Diary;
import Calendar.model.Record;
import Calendar.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private final Diary diary;
    private final Presenter presenter;
    List<Commands> commandsList;

    Scanner iScanner;

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        presenter.setConsoleUI(this);
        diary = this.presenter.readDiary();
        commandsList = new ArrayList<>();
        iScanner = new Scanner(System.in);
    }

    public Diary getDiary() {
        return diary;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void start() {
//        заполняем список команд UI
        commandsList.add(new SaveAndFinish(this));
        commandsList.add(new GetCalendar(this));
        commandsList.add(new GetDayRecords(this));
        commandsList.add(new AddRecord(this));
        commandsList.add(new FindEvent(this));
        commandsList.add(new DelRecord(this));

        while (true) {
            System.out.println("Выберите действие:");
            for (int i = 0; i < commandsList.size(); i++) {
                System.out.println(i + " - " + commandsList.get(i).description());
            }
            System.out.print("-->\t");
            String str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) & (choice < commandsList.size())) {
                    commandsList.get(Integer.parseInt(str)).execute();
                } else {
                    System.out.println("Такой команды нет! Повторите ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Попробуйте ещё раз.");
            }
        }
    }

    /*
    печать Diary
     */
    public void printDiary(Diary diary) {
        System.out.println(diary);
    }

    /*
    печать всех записей дня
     */
    public void printDay(int dayNum, Day day) {
        if (day.getRecords().size() > 0) {
            System.out.printf("Записи %s дня:\n", dayNum);
            System.out.println(day);
        } else {
            System.out.printf("Записей %s дня не обнаружено.\n", dayNum);
        }
    }

    /*
    печать записи
     */
    public void printRecord(String findedRecord) {
        System.out.println(findedRecord);
    }

    /*
    получить запись от пользователя. два режима: full (true) - для внесения новой, full (false) - для поиска и удаления
     */
    public Record getRecord(boolean full) {
        String event;
        int hour = 0;
        if (full) {
            while (true) {
                System.out.print("Введите время события -> ");
                String str = iScanner.nextLine();
                try {
                    hour = Integer.parseInt(str);
                    if ((hour >= 0) & (hour < 24)) {
                        break;
                    } else {
                        System.out.println("Время должно быть в диапазоне от 0 до 23! Повторите ввод.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Не корректный ввод! Попробуйте ещё раз.");
                }
            }
        }
        System.out.print("Введите событие -> ");
        event = iScanner.nextLine();
        return new Record(hour, event);
    }

    /*
    получить номер дня
     */
    public int getDay() {
        int day;
        while (true) {
            System.out.print("Введите день месяца -> ");
            String str = iScanner.nextLine();
            try {
                day = Integer.parseInt(str);
                if ((day >= 1) & (day <= 31)) {
                    break;
                } else {
                    System.out.println("День должен быть в диапазоне от 1 до 31! Повторите ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Попробуйте ещё раз.");
            }
        }
        return day;
    }

    /*
    вывод сообщения пользователю
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}