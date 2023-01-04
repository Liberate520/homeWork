package Seminars_OOP.HW_2;

import java.io.Serializable;

public interface Writable {

    void save(Serializable serializable);

    Object read();

}
