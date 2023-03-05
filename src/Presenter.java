public class Presenter {

    private View view;
    private Console console;
    private Human human;
    FamilyTree <Human> familyTree1;

    public Presenter(View view) {
        this.view = view;
        this.familyTree1=familyTree1;       
        view.setPresenter(this);        

    }

    public void add(Human human) {
        this.human=human;
        familyTree1.addHuman(human);
        System.out.println("презентер работает");
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
