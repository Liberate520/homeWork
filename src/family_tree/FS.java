package family_tree;

import java.io.*;

public class FS implements Writable{

    public void SaveTree(FamilyTree familyTree, String file_path)
    {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_path)))
        {
            oos.writeObject(familyTree);
            System.out.println("File has been written");
        }
        catch(Exception ex){
                
            System.out.println(ex.getMessage() + " - это ошибка");
        } 
    }

    public FamilyTree OpenTree(String file_path)
    {
        // Востановление из файла с помощью класса ObjectInputStream
        FamilyTree treeRestored = new FamilyTree();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_path)))
        {
            treeRestored = ((FamilyTree)ois.readObject());
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage() + " - это ошибка");
        } 

        return treeRestored;
    }

    public boolean fileExist(String file_path)
    {
        File file = new File(file_path);
        if(file.exists())
        {
            return true;
        }
        return false;
    }
    
}
