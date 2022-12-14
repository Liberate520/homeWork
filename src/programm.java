import Model.FamilyTree;
import Presenter.Presenter;
import view.View_tree;

public class programm {
    public static void main(String[] args) {
        String path1 = "base Human.cvs";
        String path2 = "base Pets.cvs";

        View_tree v = new View_tree();
        FamilyTree tr_human = new FamilyTree<>(path1);
        FamilyTree tr_dogs = new FamilyTree<>(path2);

        Presenter pr_human = new Presenter(v, tr_human);
        Presenter pr_dogs = new Presenter(v, tr_dogs);

        pr_human.tree_human();
        pr_dogs.pet_tree();
        
    }
}
