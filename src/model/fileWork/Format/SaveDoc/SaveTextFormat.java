package model.fileWork.Format.SaveDoc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.FamilyTree.FamilyTree;

public class SaveTextFormat<T extends FamilyTree> implements InterfaceSave<T>
{

    @Override
    public void write(FamilyTree familyTree) throws IOException, ClassNotFoundException
     {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File file = new File(pathFile);
            FileWriter writer = new FileWriter(file.getAbsolutePath(), false);
            writer.write("\nTxt Format\n");
            writer.write(familyTree.toString()); 
            writer.flush(); 
    }
    
}
