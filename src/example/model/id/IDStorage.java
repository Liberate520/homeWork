package org.example.model.id;

import java.util.ArrayList;

public class IDStorage { // хранилище существующих id
    private final ArrayList<String> ids = new ArrayList<>();


    public void addID(String id){
        this.ids.add(id);
    }

    public void removeID(String id){
        ids.remove(id);
    }

    public ArrayList<String> getIds() {
        return ids;
    }
}
