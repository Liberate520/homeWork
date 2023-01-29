package Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import Interface.FamilyTreeUI;

public class Structure_loadTree implements Select {
        FamilyTreeUI familyTreeUI;

    public Structure_loadTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        familyTreeUI.loadTree();
    }

    @Override
    public String discription() {
        return "Загрузить файл";
    }   
}
