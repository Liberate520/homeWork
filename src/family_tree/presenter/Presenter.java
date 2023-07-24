package family_tree.presenter;

//import family_tree.familytree.FamilyTree;
import family_tree.person.Gender;
import family_tree.service.Service;
import family_tree.ui.ConsoleView;
import family_tree.ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void getTree() {
        view.print(service.getTree());
    }

    public void getTreeShort() {
        view.print(service.getTreeShort());
    }

    public Boolean addToTree(String data, Gender gender) {
        return service.addToTree(data, gender);
    }

    public Boolean delFromTree(String fullName) {
        return service.delFromTree(fullName);
    }

    public String getPeakTree() {
        return service.getPeakTree();
    }

    public void getItem(String fullName) {
        String item = service.getItemByName(fullName);
        view.print(item == null ? "Никто не найден! " : item.substring(0, item.length()-1));
    }

    public void getItemShort(String fullName) {
        String item = service.getItemByNameShort(fullName);
        view.print(item == null ? "Никто не найден! " : item.substring(0, item.length()-1));
    }

    public Boolean setPeakByIndex(int index) {
        return service.setPeakByIndex(index);
    }

    public Boolean saveTree(String option){
        return service.saveTree(option);
    }

    public Boolean loadTree(String option, String filename) {
        return service.loadTree(option, filename);
    }

    public int getTreeSize() {
        return service.getTreeSize();
    }

    public void sortByName() {
        view.print(service.sortByName());
    }

    public void sortByNameReverse() {
        view.print(service.sortByNameReverse());
    }

    public void sortByAge() {
        view.print(service.sortByAge());
    }

    public void sortByAgeReverse() {
        view.print(service.sortByAgeReverse());
    }

    public void sortByDateBirth() {
        view.print(service.sortByDateBirth());
    }

    public void sortByDateBirthReverse() {
        view.print(service.sortByDateBirthReverse());
    }

    public void sortByChildren() {
        view.print(service.sortByChildren());
    }

    public void sortByChildrenReverse() {
        view.print(service.sortByChildrenReverse());
    }

    public Boolean delTree() {
        return service.delTree();
    }


    public Boolean setFullname(String itemIndex, String fullName) {
        return service.setFullname(itemIndex, fullName);
    }

    public Boolean setDateBirth(String itemIndex, int birthY, int birthM,  int birthD) {
        return service.setDateBirth(itemIndex, birthY, birthM, birthD);
    }

    public Boolean setDateEndlife(String itemIndex, int EndlifeY, int EndlifeM,  int EndlifeD) {
        return service.setDateEndlife(itemIndex, EndlifeY, EndlifeM, EndlifeD);
    }

    public Boolean setGenderChange(String itemIndex, Gender gender) {
        return service.setGenderChange(itemIndex, gender);
    }

    public Boolean setMother(String itemIndex, String motherName) {
        return service.setMother(itemIndex, motherName);
    }

    public Boolean setFather(String itemIndex, String fatherName) {
        return service.setFather(itemIndex, fatherName);
    }

    public Boolean setChild(String itemIndex, String childName) {
        return service.setChild(itemIndex, childName);
    }

    public Boolean setCommit(String itemIndex, String commit) {
        return service.setCommit(itemIndex, commit);
    }

    public void exit() {
        service.exit();
        view.print("Всего доброго!");
    }
}
