public class Presenter {

    private View view;
    private Human human;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(Human human) {
        System.out.println("презентер работает");
    }
}



// public class Presenter {

//     private View view;
//     private FamilyTree familyTree;

//     public Presenter(View view, FamilyTree<T> familyTree) {
//         this.view = view;
//         this.familyTree = familyTree;
//         view.setPresenter(this);
//     }

//     public void onClick(String command) {
//         if (command == "1") {
//             String answer = familyTreeService.getAllHumanToString(command);
//         }

//         view.print(answer);
//     }

// }

    

