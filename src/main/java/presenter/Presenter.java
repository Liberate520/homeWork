package presenter;

import notes.ActionsFile;
import notes.Formatter;
import notes.data.Note;
import notes.data.Notes;
import notes.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service.getNotes();
        view.setPresenter(this);
    }


//    public void getChois(int choice) {
//        switch (choice) {
//            case 1:
//                System.out.println(service.toString());
//                start();
//                break;
//            case 2:
//                Note note = new Note(view.scan("Введите текст заметки: "));
//                service.addNote(note);
//                System.out.println(service.toString());
//                start();
//                break;
//            case 3:
//                service.delete(Integer.parseInt(view.scan("Введите номер удаляемой заметки: ")));
//                System.out.println(service.toString());
//                start();
//                break;
//            case 4:
//                int index = Integer.parseInt(view.scan("Введите номер заметки для редактирования"));
//                String newNote = view.scan("Введите новый текст заметки");
//                service.setNote(newNote, index);
//                start();
//                break;
//            case 5:
//                service.save();
//                break;
//        }
//    }

//    public void start() {
//        int choice = view.selection();
//        getChois(choice);
//    }

    public Notes getNotes() {
        return service.getNotes();
    }
}
