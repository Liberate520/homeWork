package mvp;

import data.BlockNote;
import data.formatter.Formatter;
import data.formatter.JsonFormatter;
import storage.FileStorage;
import storage.Storage;

public class Model {
    private Storage storage = new FileStorage();
    private Formatter formatter = new JsonFormatter();
    private BlockNote blockNote;
    public Model() {
        String fileData = storage.read();
        if(fileData.equals("")){
            blockNote = new BlockNote();
        }else {
            blockNote = formatter.blockNote(storage.read());
        }
    }

    public void writeData() {
        storage.save(formatter.stringBlockNote (blockNote));
    }
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