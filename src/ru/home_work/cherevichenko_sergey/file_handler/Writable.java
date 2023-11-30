package ru.home_work.cherevichenko_sergey.file_handler;

import java.io.IOException;

public interface Writable  {
     void save(Object o) throws IOException;
     Object readable() throws IOException, ClassNotFoundException;
}
