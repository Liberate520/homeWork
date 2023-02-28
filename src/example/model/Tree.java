package org.example.model;

import org.example.model.Iterator.HumanIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree <T extends Human>  implements Iterable<T>{
    private final ArrayList <String> existingIds;  // хранит существующие id Human после загрузки с файла, для того, чтобы
                                                      //при добавлении или удалении человека, id назначались последовательно.
    {                                                 // Уадлен id 6, следующий созданный станет 6-стым.
        existingIds = new ArrayList<String>();
    }
    private String nameFamily;
    private final ArrayList<T> bigFamily;
    {
        bigFamily = new ArrayList<>();
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

    public ArrayList<String> getExistingIds() {
        return existingIds;
    }

    public void addHuman(T human){
        this.bigFamily.add(human);
        this.existingIds.add(bigFamily.get(bigFamily.size() - 1).getId());
    }


    @Override
    public Iterator<T> iterator() {
        return  new HumanIterator<>(bigFamily);
    }
}


