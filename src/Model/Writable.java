package Seminars_OOP.HW_5.src.Model;
import java.io.Serializable;

public interface Writable {

    void save(Serializable serializable);

    Object read();

}
