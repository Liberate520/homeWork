package mvp;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public String allNotes() {
        return model.blockNote();
    }
    public void writeAllNotes(){
        model.writeData();
    }
    public void writeNote(String note) {
        model.addNote(note);
    }
    public void removeNote(int noteID) {
        model.removeNote(noteID);

    }
    public void replaceNote(int noteID, String newNote) {
        model.replaceNote(noteID,newNote);

    }


//    public void addNote(String note){
////        model.
//    }
}
