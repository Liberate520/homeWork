package FileWork;

import java.io.Serializable;

public interface Writeble {
    public boolean SaveInFile(Serializable serializable, String nameFile);
    public Object LoadInFile(String nameFile);     
}
