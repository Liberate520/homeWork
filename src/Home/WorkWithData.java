package Home;

import java.io.IOException;
import java.io.Serializable;

public interface WorkWithData extends Serializable {
    void familyTreeSave(Human human) throws IOException;
    void familyTreeloadHumanDitails(Human human) throws IOException, ClassNotFoundException;
    public void familyTreeloadMotherDitails(Human human) throws IOException, ClassNotFoundException;
    public void familyTreeloadFatherDitails(Human human) throws IOException, ClassNotFoundException;
    public void familyTreeloadSistersDitails(Human human) throws IOException, ClassNotFoundException;
    public void familyTreeloadBrothersDitails(Human human) throws IOException, ClassNotFoundException;
    public void FamilyTreeloadGrandmothersDitails(Human human) throws IOException, ClassNotFoundException;
    public void familyTreeloadGrandfathersDitails(Human human) throws IOException, ClassNotFoundException;
}
