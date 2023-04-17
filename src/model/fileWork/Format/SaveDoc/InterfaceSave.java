package model.fileWork.Format.SaveDoc;

import java.io.IOException;

import model.FamilyTree.FamilyTree;

public interface InterfaceSave<T extends FamilyTree>
{
    void write(T t) throws IOException, ClassNotFoundException;
}
