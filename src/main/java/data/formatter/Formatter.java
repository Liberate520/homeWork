package data.formatter;

import com.google.gson.Gson;
import data.BlockNote;
import data.Note;

public class Formatter {

    public Formatter() {
    }

    public String json(Note note) {
        String jsonString;
        Gson gson = new Gson();

        jsonString = gson.toJson(note);
        return jsonString.toString();
    }
    public String jsonBlockNote(BlockNote blockNote){
        String jsonString;
        Gson gson = new Gson();
        jsonString = gson.toJson(blockNote);
        return jsonString;
    }
    public Note note (String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,Note.class);
    }
    public BlockNote blockNote (String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,BlockNote.class);
    }
}
