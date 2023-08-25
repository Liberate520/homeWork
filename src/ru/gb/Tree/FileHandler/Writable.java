package ru.gb.Tree.FileHandler;

import ru.gb.Tree.Service.Service;

public interface Writable {
    void saveFile(Service tree, String path);
    Object readFile(String path);
}