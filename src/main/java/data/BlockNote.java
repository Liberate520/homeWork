package data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BlockNote {
    public Map<Integer, Note> notesMap;
    private static int counter;
    public BlockNote(){
        notesMap = new HashMap<>();
    }
    public void addNote(String note){
        counter = Collections.max(notesMap.keySet());
        this.notesMap.put(++counter, new Note(note));
    }
    public void removeNote(int noteID){
        notesMap.remove(noteID);
        counter = Collections.max(notesMap.keySet());
    }
    public void replaceNote(int noteID,String note){
        notesMap.replace(noteID,new Note (note));
    }

    @Override
    public String toString() {
        if(!notesMap.isEmpty()){
            StringBuilder blockNoteString = new StringBuilder();
            for (Map.Entry<Integer,Note> entry:notesMap.entrySet()
            ) {
                blockNoteString.append(String.format("%d. %s\n",entry.getKey(),entry.getValue()));
            }
            return blockNoteString.toString();
        }
        return "";
    }
}
