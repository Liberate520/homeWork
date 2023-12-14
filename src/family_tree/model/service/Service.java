package family_tree.model.service;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.builder.HumanBuilder;
import family_tree.model.family_trees.FamilyTree;
import family_tree.model.file_system.FS;
import family_tree.model.file_system.OOS;
import family_tree.model.file_system.enums.StatusFileFS;
import family_tree.model.human.Human;
import family_tree.model.human.types_enum.Gender;

public class Service implements Serializable{
    private FamilyTree<Human> ftree;
    private HumanBuilder builder;

    FS fileOperationsOOS = new FS(new OOS());

    public Service() {
        ftree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public void addHumanToTree(String name, LocalDate birthDay, LocalDate deadDay, Gender gender){
        Human human = builder.build(name, birthDay, deadDay, gender);
        ftree.addProband(human);
    }

    public void addParentToChild(int mothers_index, int fathers_index, int child_index){
        ftree.addMotherToChild(ftree.getProbandFromList(mothers_index), ftree.getProbandFromList(child_index));
        ftree.addFatherToChild(ftree.getProbandFromList(fathers_index), ftree.getProbandFromList(child_index));
    }

    public String getFamilyTreeProbandsListInfo(){
        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");

        for (Human human: ftree){
            
            stringBuilder.append(index++);
            stringBuilder.append(". ");
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        ftree.sortByName();
    }

    public void sortByAge(){
        ftree.sortByAge();
    }

    public int getFamilyListSize()
    {
        return ftree.getFamilyListSize();
    }

    public StatusFileFS saveTreeOOS(String file_path)
    {          
        return fileOperationsOOS.Save(ftree, file_path);
    }

    public StatusFileFS loadHumanTreeOOS(String file_path)
    {
        if(fileOperationsOOS.IsFileExist(file_path))
        {           
            this.ftree = (FamilyTree<Human>) fileOperationsOOS.Read(file_path);
            return StatusFileFS.FileLoaded;
        }
        else
        {
            return StatusFileFS.NoSuchFile;
        }
    }
}
