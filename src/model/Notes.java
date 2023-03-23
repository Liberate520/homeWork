package model;

import java.io.Serializable;

public class Notes {
    private String note;

    public Notes(String note){
        this.note=note;
    }

    public String getNotes(){
        return  note;
    }

    @Override
    public String toString() {
        return "\nЗаметки " + note;
    }
}
