package model;

public class Model {

    // ПОЛЯ КЛАССА
    FileRecorder fileRecorder;
    PlanManager planManager;

    // КОНСТРУКТОР
    public Model(String path) {
        this.planManager = new PlanManager();
        fileRecorder = new FileRecorder(path, this.planManager);
    }

    // МЕТОДЫ КЛАССА
    public void addRec(String text, String deadline, String notes) {
        planManager.addRec(text, deadline, notes);
    }

    public void delRec(Integer index) {
        planManager.delRec(index);
    }


    public void changeRec(Integer index, String text, String deadline, String notes){
        planManager.changeRec(index, text, deadline, notes);
    }



    public String toString() {
        return planManager.toString();
    }

    public void load() {
        fileRecorder.load();
    }

    public void save() {
        fileRecorder.save();
    }
}