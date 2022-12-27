package DZ1;

import java.util.List;

public class Presenter<T extends Human> {
    private View view;
    private FamilyTree<T> familyTree;

    public Presenter(View view, FamilyTree<T> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public List<T> getAllHumans() {
        List<T> answer = familyTree.getAllHumans();
        return answer;
    }

    public String getHumanByNameAndRelatives(String userInputName) {
        String answer = familyTree.getHumanByNameAndRelatives(userInputName);
        return answer;
    }

    public void clearTree() {
        familyTree.clearTree();
    }

    public List<T> getHumans() {
        List<T> answer = familyTree.getHumans();
        return answer;
    }

    public void addList(List<T> read) {
        familyTree.addList(read);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByGender() {
        familyTree.sortByGender();
    }

}
