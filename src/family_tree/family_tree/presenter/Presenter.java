package family_tree.family_tree.presenter;

import family_tree.family_tree.model.FileHandler;
import family_tree.family_tree.model.service.Service;
import family_tree.family_tree.view.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler<>());
//        int index = 0;                                    // ???
//        FamilyTree familyTree = null;                     // ???
//        service = new Service(index, familyTree);         // ???
    }


    public void addHuman(String name, String gender, String birthDate) {
        String answer = service.addHuman(name, gender, birthDate);
        view.printAnswer(answer);
    }
//    public void addHuman(String name, String gender, LocalDate birthDate) {
////        LocalDate birthDate = null; // ??
////        service.addHuman(name, birthDate, deathDate, gender);
//        service.addHuman(name, gender, String.valueOf(birthDate));
//        getHumanListInfo();
//
//    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
//      String answer = null;
        view.answer(answer);
    }
    public boolean setParent(int personId, int parentId){
        if (service.checkId(personId) & service.checkId(parentId)) {
            service.setParent(personId, parentId);
            return true;
        }
        return false;
    }
    public void sortByName() {
//      service.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
//      service.sortByAge();
        getHumanListInfo();
    }
    public void sortById() {
        service.sortById();
        getHumanListInfo();
    }
    public boolean read(String filePath) {
        return service.read(filePath);
    }

    public boolean save(String filePath) {
        return service.save(filePath);
    }
}