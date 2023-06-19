package Models;

import java.util.List;

import Models.Items.Notes;
import Models.Items.Post;
import Models.Repositories.Keeper;

public class Service {
    private Notes<Post> notes;
    private Keeper<Notes<Post>> keeper;
    private int index = 0;

    public Service(Keeper<Notes<Post>> keeper) {
        this.keeper = keeper;
        getNotes();
    }

    /** получение сохраненных записей, или создание нового списка */
    private void getNotes() {
        notes = keeper.read();
        if (notes == null) {
            notes = new Notes<>();
        }
    }

    /** сохранение */
    public boolean save(){
        return keeper.save(notes);
    }

    /** получение детальной информации по id */
    public String getDetail(int id) {
        List<Post> items = notes.getFilteredItems((item) -> item.getId() == id);
        if (items.size() > 0) {
            return items.get(0).toString();
        }
        return "post not found";
    }

    /** получение детальной информации по заголовку статьи */
    public String getDetail(String header) {
        List<Post> items = notes.getFilteredItems((item) -> item.getHeader().equals(header));
        if (items.size() > 0) {
            return items.get(0).toString();
        }
        return "post not found";
    }

    @Override
    public String toString() {
        return getFilteredString(notes.getFilteredItems((item) -> true));
    }

    /** фильтр по автору */
    public String getNotesListByAuthor(String author) {
        return getFilteredString(notes.getFilteredItems((item) -> item.getAuthor().equals(author)));
    }

    /** получение фильтрованных статей */
    private String getFilteredString(List<Post> items) {
        StringBuilder builder = new StringBuilder();
        for (Post post : items) {
            builder.append(post.getShort());
            builder.append("\n");
        }
        return builder.toString();
    }

    /** сортировка по id */
    public void sortById() {
        notes.sortById();
    }

    /** сортировка по заголовку */
    public void sortByHeader() {
        notes.sortByHeader();
    }

    /** сортировка по автору */
    public void sortByAuthor() {
        notes.sortByAuthor();
    }

    /** сортировка по дате изменения */
    public void sortByDateOfChange() {
        notes.sortByDateOfChange();
    }

    /** сортировка по дате создания */
    public void sortByDateOfCreation() {
        notes.sortByDateOfCreation();
    }

    /** создание новой записи */
    public boolean create(String header, String content, String author) {
        notes.add(new Post(index++, header, content, author));
        return true;
    }

    /** обновление статьи */
    public boolean update(int id, String header, String content, String author){
        List<Post> items =  notes.getFilteredItems((item) -> item.getId().equals(id));
        if(items == null || items.size() == 0) {
            return false;
        }
        items.get(0).update(header, content, author);
        return true;
    }

    /** удаление статьи */
    public boolean remove(int id) {
        List<Post> items =  notes.getFilteredItems((item) -> item.getId().equals(id));
        if(items == null || items.size() == 0) {
            return false;
        }
        notes.remove(items.get(0));
        return true;
    }

    /** очистка списка статей */
    public boolean clear() {
        
        return notes.clear();
    }

}
