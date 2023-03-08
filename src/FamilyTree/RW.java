package src.FamilyTree;

import java.io.Serializable;

public interface RW {
    boolean write(Serializable obj);
    Object read();
}
