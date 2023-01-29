package Calendar;

import Calendar.files.FileHandler;
import Calendar.files.Service;
import Calendar.presenter.Presenter;
import Calendar.UI.ConsoleUI;
import Calendar.UI.View;

public class Program {
    public static void main(String[] args) {
        String filename = "calendar.dat";
        FileHandler fileHandler = new FileHandler(filename);
        Service service = new Service(fileHandler, filename);
        Presenter presenter = new Presenter(service);
//        создаём consoleUI и передаём ему презентер
        View consoleUI = new ConsoleUI(presenter);
//        запускаем
        consoleUI.start();


    }
}