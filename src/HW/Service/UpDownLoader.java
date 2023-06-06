package HW.Service;

import HW.Tree.FamilyTree;

import java.io.IOException;

public interface UpDownLoader {
    public void saver(FamilyTree tree) throws IOException;
    public FamilyTree recovery() throws IOException, ClassNotFoundException;
}
