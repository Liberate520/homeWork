package familyTree.Presenter;
import familyTree.Model.PersonPack.Gender;
import familyTree.Model.Service.Service;
import familyTree.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean addPerson(String name, Gender gender, String date){
        service.addPerson(name, gender, date);
        return true;
    }

    public boolean setParent(int personId, int parentId){
        if (service.checkId(personId) & service.checkId(parentId)){
            service.setParent(personId,parentId);
            return true;
        }
        return false;
    }

    public void treeInfo(){
        view.printAnswer(service.getFamilyInfo());
    }

    public void treeSortedByAge(){
        view.printAnswer(service.listSortByAge());
    }

    public void treeSortedByChildren(){
        view.printAnswer(service.listSortByChildren());
    }

    public boolean restoreTree(String filePath){
        return service.restoreTree(filePath);
    }

    public boolean saveTree(String fileName){
        return service.saveTree(fileName);
    }
}
