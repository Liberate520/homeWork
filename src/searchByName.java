public class searchByName<T extends People> implements Option{

    ViewFamilyTree<T> viewTree;

    public void searchByName(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }
    @Override
    public void execute() {
       viewTree.searchByName();
    }

    @Override
    public String info() {
        return "Найти людей по имени и вывести в консоль";
    }
    
}
