package Family_Tree.presenter;

import Family_Tree.model.Human.Gender;
import Family_Tree.view.View;
import Family_Tree.model.Service.Service;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean add(String name, LocalDate birthday, Gender gender) {
        service.add(name, birthday, gender);
        return true;
    }

    public void getHumanListInfo() {
        String answer = view.getHumanListInfo();
        view.answer(answer);
    }

    public void sortByName() {
        service.sortByName();
        view.getHumanListInfo();
    }

    public void sortByBirthday() {
        service.sortByBirthday();
        view.getHumanListInfo();
    }

    public boolean addToParents (int humanId, int parentId){
        if (service.checkId(humanId) & service.checkId(parentId)){
            service.addToParents(humanId,parentId);
            return true;
        }
        return false;
    }

    public boolean read(String filePath){
        return service.read(filePath);
    }

    public boolean save(String fileName){
        return service.save(fileName);
    }


}
