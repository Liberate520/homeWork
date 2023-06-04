package tree;


import java.io.Serializable;

public abstract interface Load {
    Serializable load(String path, Serializable obj);
}