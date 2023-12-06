package FileWork;

import java.io.Serializable;

public interface Writeble {
    public boolean saveInFile(Serializable serializable, String nameFile);
    public Object loadInFile(String nameFile);     
}
