package model;

import java.io.IOException;

public interface Datatable {
    public void save(Object object);
    public Object read();
}
