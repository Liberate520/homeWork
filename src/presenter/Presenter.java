package presenter;

import model.exception.HumanExcistsException;
import model.human.Gender;
import model.service.Service;
import model.writer.Writable;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String lastName, Gender gender) throws HumanExcistsException {
        service.addHuman(name, lastName, gender);
        getFamilyInfo();
    }

    public void getFamilyInfo(){
        String info = service.getFamilyInfo();
        view.printAnswer(info);
    }
    public void sortByAge(){
        service.sortByAge();
        getFamilyInfo();
    }

    public void sortByName(){
        service.sortByName();
        getFamilyInfo();
    }
    public void addSpouse(int one, int two) {
        service.addSpouse(one, two);
        getBodyInfoById(one);
    }
    public void addChild(int parentId, int childId) {
        service.addChild(parentId, childId);
        getBodyInfoById(parentId);
    }
    public boolean setBirthday(int id, int year, int month, int day) {
        if (service.setBirthday(id, year, month, day)) {
            getBodyInfoById(id);
            return true;
        }
        return false;
    }
    public void getBodyInfoById(int id) {
        view.printAnswer(service.infoByID(id));
    }
    public boolean checkId(int id) {
        return service.checkId(id);
    }
        public boolean save() {
        return service.save();
    }

    public void load() throws IOException {
        service.load();
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
    public boolean setDeathdate(int id, int year, int month, int day) {
        if (service.setDeathdate(id, year, month, day)) {
            getBodyInfoById(id);
            return true;
        }
        return false;
    }
}
