package App;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Interface.View;
import Model.FamilyTree;
import Model.FamilyTreeOperator;
import Model.Human;
import Operations.FileHandler;

public class Presenter<T extends Human> {
    private View view;
    private FamilyTree<T> familyTree;
    private FamilyTreeOperator familyTreeOperator;
    private FileHandler fileHandler = new FileHandler();

    public Presenter() {
    }

    public Presenter(View view, FamilyTree<T> familyTree, FamilyTreeOperator familyTreeOperator) {
        this.view = view;
        this.familyTree = familyTree;
        this.familyTreeOperator = familyTreeOperator;
        view.setPresenter(this);
    }


    public String getHumanByNameAndRelatives(String userInputName) {
        String answer = familyTreeOperator.getHumanByNameAndRelatives(userInputName);
        return answer;
    }

    public void clearTree() {
        familyTreeOperator.clearTree();
    }

    public List<T> getHumans() {
        List<T> answer = familyTree.getHumans();
        return answer;
    }

    public void addList(List<T> read) {
        familyTreeOperator.addList(read);
    }

    public void sortByName() {
        familyTreeOperator.sortByName();
    }

    public void sortByGender() {
        familyTreeOperator.sortByGender();
    }

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        familyTreeOperator.setRecording(fileHandler);
        familyTreeOperator.loadTree();
    }

    public void saveTree() throws IOException {
        familyTreeOperator.setRecording(fileHandler);
        familyTreeOperator.saveTree(getHumans());
    }

}
