package presenter;


import human.Comparators.DateComparator;
import human.Comparators.NameComparator;
import human.Human;
import service.Service;
import tree.FamilyTree;
import tree.FindScanner;
import ui.View;
public class Presenter<T> {
    private View<T> view;
    private Service<T> service;

    private FamilyTree<Human> familyTree = new FamilyTree();

    public Presenter(View<T> view, Service<T> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public T getFamilyTree(T t)
    {
        return t;
    }
    public T printTree(T t)
    {
        view.print(t);
        return t;
    }

    public T findHuman(T t)
    {
        FindScanner name = new FindScanner();
        familyTree.find(name.findScanner());
        return t;
    }

    public void sortByName(T t)
    {   System.out.println("Список, отсортированный по имени: \n");
        familyTree.getFamilyTree().sort(new NameComparator());

    }

    public void sortByDate(T t)
    {   System.out.println("Список, отсортированный по дате смерти: \n");
        familyTree.getFamilyTree().sort(new DateComparator());

    }

}
