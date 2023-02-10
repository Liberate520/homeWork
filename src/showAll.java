public class showAll<T extends People> implements Option{

    ViewFamilyTree<T> viewTree;

    public showAll(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
        viewTree.showAll();
    }

    @Override
    public String info() {
        return "Вывести список всех людей";
    }
}
