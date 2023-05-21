package model.famalyTree;


import java.io.Serializable;

public interface Savable {
    void save(Serializable serializable, String path);
    Object upload(String path);
}
