package model.fileWork.Format.SaveDoc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.FamilyTree.FamilyTree;

public class SaveBinFormat<T extends FamilyTree> implements InterfaceSave<T> 
{

    @Override
    public void write(FamilyTree familyTree) throws IOException, ClassNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("text.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(familyTree);
            fos.close();
    }


    
}
