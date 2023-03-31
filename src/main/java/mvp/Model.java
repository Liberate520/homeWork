package mvp;

import data.BlockNote;
import data.formatter.Formatter;
import storage.FileStorage;
import storage.Storage;

public class Model {
    private Storage storage = new FileStorage();
    private Formatter formatter = new Formatter();
    private BlockNote blockNote;
    public Model() {
        String fileData = storage.read();
        if(fileData.equals("")){
            blockNote = new BlockNote();
        }else {
            blockNote = formatter.blockNote(storage.read());
        }

    }

//    public String readData() {
//        return storage.read();
//    }

//    public Note readNote() {
//        return storage.readNote();
//    }

    public void writeData() {
        storage.save(formatter.jsonBlockNote (blockNote));
    }
//    public void writeNote(Note note) {
//        String jsonNote = new Formatter().json(note);
//        storage.writeNote(jsonNote);
//    }
//    public void writeBlockNote(BlockNote blockNote) {
//        String jsonNote = new Formatter().jsonBlockNote(blockNote);
//        storage.writeNote(jsonNote);
//    }
    public void addNote(String note){
        blockNote.addNote(note);
    }
    public void removeNote(int noteID){
        blockNote.removeNote(noteID);
    }
    public void replaceNote(int noteID,String note){
        blockNote.replaceNote(noteID,note);
    }
    public String blockNote(){
        return blockNote.toString();
    }

}
