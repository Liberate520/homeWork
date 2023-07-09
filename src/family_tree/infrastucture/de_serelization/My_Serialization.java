package family_tree.infrastucture.de_serelization;

import family_tree.infrastucture.Config;

import java.io.Serial;
import java.io.Serializable;

public interface My_Serialization extends Serializable{
    @Serial
    long serialVersionUID = Config.serialVersionUID;
    boolean save(Serializable serializable, String filePath);
    Object load(String filePath);
}
