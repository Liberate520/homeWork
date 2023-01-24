// Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
// Или создание нового проекта "Календарь": задача создать календарь в котором есть возможность
//  делать записи на определенный день. Работа через консоль. Должна быть реализована возможность 
//  просмотра календаря, просмотра записей на определенный день, добавление записей (например "в 14:00 стоматолог").
//   Реализована возможность сохранения календаря в файл и восстановление из файла. Этот проект должен быть выполнен 
//   также с учетом принципов SOLID’а

import file.FileHandler;
import file.BackupAndRead;
import model.Calendar;
import presenter.Presenter;
import ui.Console;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        FileHandler fileHandler = new FileHandler();
        BackupAndRead files = new BackupAndRead(fileHandler);
        Presenter presenter = new Presenter(files,calendar);
        Console console = new Console(presenter);
        console.start();

    }
}
