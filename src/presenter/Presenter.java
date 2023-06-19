package presenter;

import model.Service;
import model.repository.FileHandler;

import java.time.LocalDate;

public class Presenter {
    private Service service;

    public Presenter() {
        service = new Service(new FileHandler("/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/tree.txt"));
    }

    public String getMembersNames() {
        return service.getMembersNames();
    }

    public String getMalesNames() {
        return service.getMaleNames();
    }

    public String getFemalesNames() {
        return service.getFemaleNames();
    }

    public String getGendersList() {
        return service.getGenderList();
    }

    public int getMaleAmount() {
        return service.getMaleAmount();
    }

    public int getFemaleAmount() {
        return service.getFemaleAmount();
    }

    public int getAllMembersAmount() {
        return service.getAllAmount();
    }

    public String getGender(int index) {
        return service.getGenderBy(index);
    }

    public String getMaleName(int index) {
        return service.getMaleName(index);
    }
    public String getFemaleName(int index) {
        return service.getFemaleName(index);
    }
    public String getMemberDetail(int index) {
        return service.getMemberDetail(index);
    }
    public void save() {
        service.save();
    }
    public void updateMember(Integer index, String name, LocalDate date, Integer gender, Integer fatherIndex, Integer motherIndex) {
        service.updateMember(index, name, date, gender, fatherIndex, motherIndex);
    }
    public void addNewMember(String fullName, LocalDate date, int gender, int father, int mother) {
        service.addNewMember(fullName, date, gender, father, mother);
    }
}
