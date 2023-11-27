package ru.home_work.cherevichenko_sergey;
import java.io.IOException;

// интерфейс, для того чтобы пользоваться классами записи и чтения
// методы для записи и чтения
public interface Writable {
    void save(Object o) throws IOException;
        Object readable() throws IOException, ClassNotFoundException;


}
