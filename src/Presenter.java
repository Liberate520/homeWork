package DZ1;

import java.util.List;

public class Presenter {
    private View view;
    private FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public List<Human> getAllHumans() {
        List answer = familyTree.getAllHumans();
        return answer;
    }

    public String getHumanByNameAndRelatives(String userInputName) {
        String answer = familyTree.getHumanByNameAndRelatives(userInputName);
        return answer;
    }

    public void clearTree() {
        familyTree.clearTree();
    }

    public List<Human> getHumans() {
        List answer = familyTree.getHumans();
        return answer;
    }

    public void addList(List<Human> read) {
        familyTree.addList(read);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByGender() {
        familyTree.sortByGender();
    }

}
