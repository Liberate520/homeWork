package org.example.model;

import org.example.model.Iterator.HumanIterator;
import org.example.model.id.IDStorage;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree <T extends Human>  implements Iterable<T>{
    private final IDStorage idStorage = new IDStorage();  // хранит существующие id Human после загрузки с файла, для того, чтобы
                                                    //при добавлении или удалении человека, id назначались последовательно.// Уадлен id 6, следующий созданный станет 6-стым.
    private String nameFamily;
    private final ArrayList<T> bigFamily;
    {
        bigFamily = new ArrayList<>();
    }
    public IDStorage getIdStorage() {
        return idStorage;
    }
    public String getNameFamily() {
        return nameFamily;
    }
    public void setNameFamily(String nameFamily) {
        this.nameFamily = nameFamily;
    }
    public ArrayList<T> getBigFamily() {
        return bigFamily;
    }
    @Override
    public Iterator<T> iterator() {
        return  new HumanIterator<>(bigFamily);
    }
}


