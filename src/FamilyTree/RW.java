package src.FamilyTree;

import java.io.Serializable;

public interface RW {
    void write(Serializable obj);
    Object read();
}
