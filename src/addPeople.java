public class addPeople<T extends People> implements Option{

    ViewFamilyTree<T> viewTree;

    public addPeople(ViewFamilyTree<T> viewTree){
        this.viewTree = viewTree;
    }

    @Override
    public void execute() {
        viewTree.addPeople();
    }

    @Override
    public String info() {
        return "Добаить человека в фамильное древо";
    }
}
