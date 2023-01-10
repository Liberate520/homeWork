package Seminars_OOP.HW_3;

import java.io.Serializable;

public interface Writable {

    void save(Serializable serializable);

    Object read();

}
