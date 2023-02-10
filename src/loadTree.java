public class loadTree<T extends People> implements Option {

    ViewFamilyTree viewTree;

    public loadTree(ViewFamilyTree viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
        viewTree.loadTree();
    }

    @Override
    public String info() {
        return "Сохранение файла в формате .bin";
    }
    
}
