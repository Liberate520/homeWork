// Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
// Или создание нового проекта "Календарь": задача создать календарь в котором есть возможность делать записи на определенный день.
// Работа через консоль. Должна быть реализована возможность просмотра календаря, просмотра записей на определенный день, добавление записей (например "в 14:00 стоматолог").
// Реализована возможность сохранения календаря в файл и восстановление из файла. Этот проект должен быть выполнен также с учетом принципов SOLID’а
package homeWork.src.finalProjectDiary;

import homeWork.src.finalProjectDiary.file.FileHandler;
import homeWork.src.finalProjectDiary.file.Service;
import homeWork.src.finalProjectDiary.presenter.Presenter;
import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        String filename = "calendar.dat";
        FileHandler fileHandler = new FileHandler(filename);
        Service service = new Service(fileHandler, filename);   // ???
//        Diary diary = service.readDiary();
//        Diary diary = new Diary(fileHandler);
//        Presenter presenter = new Presenter(diary, service);
        Presenter presenter = new Presenter(service);
//        создаём consoleUI и передаём ему diary, презентер
//        ConsoleUI consoleUI = new ConsoleUI(diary, presenter);
        ConsoleUI consoleUI = new ConsoleUI(presenter);
//        запускаем
        consoleUI.start();


    }
}
