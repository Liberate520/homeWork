public class sortByName<T extends People> implements Option {

    private ViewFamilyTree<T> viewTree;

    public sortByName(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
       viewTree.sortByName(); 
    }

    @Override
    public String info() {
        return "Сортировка списка людей по имени";
    }
}
