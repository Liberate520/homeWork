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

    public void add(String name, LocalDate birthday, Gender gender) {
        service.add(name, birthday, gender);
        getStudentListInfo();
    }

    public void getStudentListInfo() {
        String answer = service.getHumanListInfo();
        view.answer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getStudentListInfo();
    }

    public void sortByBirthday() {
        service.sortByBirthday();
        getStudentListInfo();
    }

    public boolean read(String filePath){
        return service.read(filePath);
    }

    public boolean save(String fileName){
        return service.save(fileName);
    }

}
