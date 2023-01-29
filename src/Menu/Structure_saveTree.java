package Menu;
import java.io.IOException;
import Interface.FamilyTreeUI;

public class Structure_saveTree implements Select {
    FamilyTreeUI familyTreeUI;

    public Structure_saveTree(FamilyTreeUI familyTreeUI) {
        this.familyTreeUI = familyTreeUI;
    }

    @Override
    public void execute() throws IOException {
        familyTreeUI.saveTree();
    }

    @Override
    public String discription() {
        return "Сохранить в файл";
    }
}
