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

    private void getNotes() {
        notes = keeper.read();
        // if(notes == null){
        //    setDefault();
        // }
        if (notes == null) {
            notes = new Notes<>();
        }
    }

    private void setDefault() {
        notes = new Notes<>();
        create("header1",  "content1",  "author1");
        create("header2",  "content2",  "author1");
        create("header3",  "content3",  "author2");
        create("header4",  "content4",  "author1");
        create("header5",  "content5",  "author2");
        create("header6",  "content6",  "author1");
        create("header7",  "content7",  "author4");
        create("header8",  "content8",  "author3");
        create("header9",  "content9",  "author4");
        create("header10", "content10", "author1");
        create("header11", "content11", "author3");
        create("header12", "content12", "author2");
        create("header13", "content13", "author4");
        create("header14", "content14", "author2");
        create("header15", "content15", "author3");
    }

    public boolean save(){
        return keeper.save(notes);
    }

    public String getDetail(int id) {
        List<Post> items = notes.getFilteredItems((item) -> item.getId() == id);
        if (items.size() > 0) {
            return items.get(0).toString();
        }
        return "post not found";
    }

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

    public String getNotesListByAuthor(String author) {
        return getFilteredString(notes.getFilteredItems((item) -> item.getAuthor().equals(author)));
    }

    private String getFilteredString(List<Post> items) {
        StringBuilder builder = new StringBuilder();
        for (Post post : items) {
            builder.append(post.getShort());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void sortById() {
        notes.sortById();
    }

    public void sortByHeader() {
        notes.sortByHeader();
    }

    public void sortByAuthor() {
        notes.sortByAuthor();
    }

    public void sortByDateOfChange() {
        notes.sortByDateOfChange();
    }

    public void sortByDateOfCreation() {
        notes.sortByDateOfCreation();
    }

    public boolean create(String header, String content, String author) {
        notes.add(new Post(index++, header, content, author));
        return true;
    }

    public boolean update(int id, String header, String content, String author){
        List<Post> items =  notes.getFilteredItems((item) -> item.getId().equals(id));
        if(items == null || items.size() == 0) {
            return false;
        }
        items.get(0).update(header, content, author);
        return true;
    }

    public boolean remove(int id) {
        List<Post> items =  notes.getFilteredItems((item) -> item.getId().equals(id));
        if(items == null || items.size() == 0) {
            return false;
        }
        notes.remove(items.get(0));
        return true;
    }

    public boolean clear() {
        
        return notes.clear();
    }

}
