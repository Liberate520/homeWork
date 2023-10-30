package ru.gb.f_tree.writer;


import java.io.Serializable;

public interface Writable {

    boolean write(Serializable serializable, String filepath);

    Object read(String filepath);
}
