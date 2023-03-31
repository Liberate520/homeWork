package data.formatter;

import com.google.gson.Gson;
import data.BlockNote;

public class JsonFormatter implements Formatter{


    @Override
    public String stringBlockNote(BlockNote blockNote) {
        String jsonString;
        Gson gson = new Gson();
        jsonString = gson.toJson(blockNote);
        return jsonString;
    }

    @Override
    public BlockNote blockNote(String stringBlockNote) {
        Gson gson = new Gson();
        return gson.fromJson(stringBlockNote,BlockNote.class);
    }
}
