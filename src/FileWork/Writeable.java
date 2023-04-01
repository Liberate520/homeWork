package FileWork;
import java.io.FileNotFoundException;

import Group.FamilyTree;

public interface Writeable{
    public static void SaveToFile(FamilyTree familyTree, String filename) throws FileNotFoundException{};   
    public static FamilyTree LoadFromFile(String filename){
        FamilyTree familyTree=new FamilyTree();
        return familyTree;
    }; 
      
}
