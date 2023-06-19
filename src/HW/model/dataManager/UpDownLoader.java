package HW.model.dataManager;

import HW.model.tree.FamilyTree;

import java.io.IOException;

public interface UpDownLoader {
    public void saver(FamilyTree tree) throws IOException;
    public FamilyTree recovery() throws IOException, ClassNotFoundException;
}
