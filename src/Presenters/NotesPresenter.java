package Presenters;

import Models.Service;
import Models.Repositories.BinaryKeeper;


public class NotesPresenter {
    public Service service;

    public NotesPresenter() {
        service = new Service(new BinaryKeeper<>("notes.bin"));
    }

    /** получение списка записей */
    public String show(String sorter, String author) {
        if(sorter != null){
            switch(sorter){
                case "si": service.sortById(); break;
                case "sh": service.sortByHeader(); break;
                case "sa": service.sortByAuthor(); break;
                case "scr": service.sortByDateOfChange(); break;
                case "sch": service.sortByDateOfCreation(); break;
            }            
        }
        
        if(author != null){
            return service.getNotesListByAuthor(author);
        }

        return service.toString();
    }

    /** получение деталей записи по заголовку */
    public String getNote(String header) {
        return service.getDetail(header);
    }

    /** получение деталей записи по индеку */
    public String getNote(int id) {
        return service.getDetail(id);
    }

    /** добавление записи */
    public boolean addNote(String header, String content, String author) {
        return service.create(header, content, author);
    }

    /** редактирование записи */
    public boolean updateNote(int id, String header, String content, String author){
        return service.update(id, header, content, author);
    }

    /** удаление записи */
    public boolean remove(int id) {
        return service.remove(id);
    }

    /** сохранение */
    public boolean save() {
        return service.save();
    }

    /** очистка */
    public boolean clear() {
        return service.clear();
    }
}
