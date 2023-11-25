package family_tree.model.service;

import java.io.Serializable;
import java.time.LocalDate;

import family_tree.model.builder.HumanBuilder;
import family_tree.model.family_trees.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.types_enum.Gender;

public class Service implements Serializable{
    private FamilyTree<Human> ftree;
    private HumanBuilder builder;

    public Service() {
        ftree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public void addHumanToTree(String name, LocalDate birthDay, LocalDate deadDay, Gender gender){
        Human human = builder.build(name, birthDay, deadDay, gender);
        ftree.addProband(human);
    }

    public void addParentToChild(int mothers_index, int fathers_index, int child_index){
        if(mothers_index == -1)
        {
            ftree.addMotherToChild(null, ftree.getProbandFromList(child_index));
        }
        else if(fathers_index == -1)
        {
            ftree.addFatherToChild(null, ftree.getProbandFromList(child_index));
        }
        else
        {
            ftree.addMotherToChild(ftree.getProbandFromList(mothers_index), ftree.getProbandFromList(child_index));
            ftree.addFatherToChild(ftree.getProbandFromList(fathers_index), ftree.getProbandFromList(child_index));
        }
    }

    public String getFamilyTreeHumansListInfo(){
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
}
