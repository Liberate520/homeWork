public class sortByDate<T extends People> implements Option {


    ViewFamilyTree<T> viewTree;

    public sortByDate(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
       viewTree.sortByDate();
        
    }

    @Override
    public String info() {
        return "Сортировка списка людей по дате рождения";
    }
    
}
