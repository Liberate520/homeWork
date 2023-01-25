package Seminars_OOP.HW_6.src.Model;
import java.io.Serializable;

public interface Writable {

    void save(Serializable serializable);

    Object read();

}
