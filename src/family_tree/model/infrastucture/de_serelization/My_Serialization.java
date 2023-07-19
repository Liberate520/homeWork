package family_tree.model.infrastucture.de_serelization;

import family_tree.model.infrastucture.Config;

import java.io.Serializable;

public interface My_Serialization extends Serializable{
    long serialVersionUID = Config.serialVersionUID;
    boolean save(Serializable serializable, String filePath);
    Object load(String filePath);
}
