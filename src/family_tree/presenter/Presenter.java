package family_tree.presenter;

import family_tree.model.person.Gender;
import family_tree.model.service.Service;
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

    public Boolean isContainsItem(String fullName) {
        return service.isContainsItem(fullName);
    }

    public Boolean isTreeEmpty() {
        return service.isTreeEmpty();
    }

    public int getTreeSize() {
        return service.getTreeSize();
    }

    public void getTree() {
        view.repeatLine();
        view.print(service.getTree());
        view.repeatLine();
    }

    public void getTreeShort() {
        view.repeatLine();
        view.print(service.getTreeShort());
        view.repeatLine();
    }

    public void getItem(String fullName) {
        String item = service.getItemByName(fullName);
        view.repeatLine();
        view.print(item);
        view.repeatLine();
    }

    public void getItemShort(String fullName) {
        String item = service.getItemByNameShort(fullName);
        view.repeatLine();
        view.print(item.substring(0, item.length()-1));
        view.repeatLine();
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

    public Boolean addPersonToTree(String data) {
        return service.addPersonToTree(data);
    }

    public Boolean delFromTree(String fullName) {
        return service.delFromTree(fullName);
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

    public void getPeakTree() {
        view.repeatLine();
        view.print(service.getPeakTree());
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

    public Boolean delTree() {
        return service.delTree();
    }

    public void exit() {
        view.print("Всего доброго!");
        service.exit();
    }

}
