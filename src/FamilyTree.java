import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Family tree
 */
public class FamilyTree implements Serializable{
    private List<Human> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    /** added new member */
    public void addNewMember(Human human) {
        if(!contains(human)){
            family.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if(human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }

    /** checked contains member in family list */
    private Boolean contains(Human search) {
        for (Human human : family) {
            if (human.equals(search)) {
                return true;
            }
        }
        return false;
    }

    /** representation */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Human human : family) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }

    public void save(String path, CapableOfPreserving preserve) throws ClassNotFoundException, IOException{
        preserve.save(path, this);
    }

    public FamilyTree read(String path, CapableOfRestore restore) throws ClassNotFoundException, IOException{
        return (FamilyTree)restore.read(path);
    }
}
