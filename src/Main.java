import notebook.Note;
import notebook.Notebook;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Создаю несколько заметок и добавляю в книжку для возможности ее просмотра и
        // удаления заметок. В случае, если заметок нет, будет вывод  в консоль:
        // "В записной книжке нет записей!"

        Note note1 = new Note(LocalDate.now(),"семинар JAVA вторник", "важно");
        Note note2 = new Note(LocalDate.now(),"лекция фин. математика", "несрочно");
        Notebook notebook = new Notebook();
        notebook.add(note1);
        notebook.add(note2);

        View view = new ConsoleUI();
        Presenter presenter = new Presenter(notebook, view);

        presenter.onClick();


    }
}
