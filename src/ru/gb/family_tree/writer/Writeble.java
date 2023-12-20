package ru.gb.family_tree.writer;

import java.io.Serializable;
i

public interface Writable{

    boolean writeObject(Object o, String fileName);
    Object readObject(String fileName);
    boolean close();

}
//public interface Writeble {
//    boolean save(Serializable serializable, String path);
//    Object read(String path);
//}
