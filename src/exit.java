public class exit<T extends People> implements Option{

    ViewFamilyTree<T> viewTree;

    public exit(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }
    @Override
    public void execute() {
        viewTree.exit();
    }

    @Override
    public String info() {
        return "Выйти из программы";
    }

}
