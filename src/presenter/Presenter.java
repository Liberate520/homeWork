package presenter;

import model.HumanService;
import model.members.Gender;
import model.members.Member;

import java.io.Serializable;

public class Presenter implements Serializable {
    private HumanService humanService;

    public Presenter() {
        this.humanService = new HumanService();
    }

    public HumanService getHumanService() {
        return humanService;
    }

    public void importFile(String filePath) {
        humanService.importFile(filePath);
    }

    public void saveFile() {
        humanService.saveFile();
    }


    public void addRecord(String name, String gender, String dateOfBirth) {
        int year = Integer.parseInt(dateOfBirth);

        if (Gender.fromStringValue(gender) != null) {
            humanService.addRecord(name, Gender.fromStringValue(gender), year);
        } else {
            System.out.println("Неверно указан пол");
        }
    }

    public Member getRecord(String name, String year) {
        int num = Integer.parseInt(year);
        return humanService.getRecord(name, num);
    }

    public void getAllRecord() {
        humanService.getAllRecord();
    }

    public void getParents(String name, String yearOfBirth) {
        int num = Integer.parseInt(yearOfBirth);
        humanService.getParents(name, num);
    }
}
