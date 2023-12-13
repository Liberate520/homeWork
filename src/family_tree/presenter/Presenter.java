package family_tree.presenter;

import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addFamilyMember(String gender, String name, String familyName, String strDate) {
        service.addFamilyMember(gender, name, familyName, strDate);
        getFamilyTreeMembers();
    }

    public void getFamilyTreeMembers() {
        String answer = service.getFamilyTreeMembers();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeMembers();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeMembers();
    }

    public boolean saveTreeToFile() {
        return service.saveTreeToFile();
    }

    public void getTreeFromFile() {
        System.out.println(service.getTreeFromFile());
    }

    public void setWedding(long humanId1, long humanId2) {
        service.setWedding(humanId1, humanId2);
        getFamilyTreeMembers();
    }

    public void setFather(long childId, long fatherId) {
        service.setFather(childId, fatherId);
        getFamilyTreeMembers();
    }

    public void setMother(long childId, long motherId) {
        service.setMother(childId, motherId);
        getFamilyTreeMembers();
    }

    public void getChildrenList(long parentId) {
        String answer;
        if (service.getChildrenList(parentId) != null) {
            answer = service.getChildrenList(parentId);
        } else {
            answer = null;
        }
        view.printAnswer(answer);
    }
}
