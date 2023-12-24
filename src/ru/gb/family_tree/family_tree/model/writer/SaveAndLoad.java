package ru.gb.family_tree.family_tree.model.writer;

import java.io.Serializable;

public interface SaveAndLoad {
    public boolean save(Serializable serializable, String path);
    public Object load(String path);
    public String getPath();
}
