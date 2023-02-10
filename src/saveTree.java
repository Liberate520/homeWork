public class saveTree<T extends People> implements Option {

    ViewFamilyTree<T> viewTree;

    public saveTree(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
        viewTree.saveTree();
    }

    @Override
    public String info() {
        return "Сохранение файла в формате .bin";
    }
    
}
