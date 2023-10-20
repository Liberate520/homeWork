package Model.FamTreeModel.FileWork;

import java.io.Serializable;

public interface Save {
    boolean write(Serializable serial, String path);
    Object read(String path);
    }

