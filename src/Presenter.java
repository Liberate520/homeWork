public class Presenter {

    private View view;
    private Console console;
    private Human human;
    private FamilyTree <Human> familyTree1;

    public Presenter(View view) {
        this.view = view; 
        view.setPresenter(this);

    }

    public boolean add(String name, String gender, Integer birthYear, String fatherName, String motherName) {       
        return familyTree1.addHuman(human);
    }
}

// public class Presenter {

// private View view;
// private FamilyTree familyTree;

// public Presenter(View view, FamilyTree<T> familyTree) {
// this.view = view;
// this.familyTree = familyTree;
// view.setPresenter(this);
// }

// public void onClick(String command) {
// if (command == "1") {
// String answer = familyTreeService.getAllHumanToString(command);
// }

// view.print(answer);
// }

// }
