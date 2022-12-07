package controller;

import model.HumanList;
import model.Output;
import model.SaveTo;

public class Controller {

    private HumanList list = new HumanList();
    private SaveTo s = new SaveTo();
    private Output output = new Output();

    public void consolePrintAllHumans(){
        output.consolePrintAllHumans(list);
    }

    public void addHuman(String name, Integer age){
        list.addHuman(name, age);
    }

    public void removeHuman(int id){
        list.removeHuman(id);
    }

    public void printChildrens(int id){
        list.printChildrens(id);
    }

    public void addReletionToHuman(int id, int relationId, int reletionToHumanId){
        list.addReletionToHuman(id, relationId, reletionToHumanId);
    }

    public void addToTxt(int id){
        s.addToTxt(list,id);
    }

    public void addToDoc(int id){
        s.addToDoc(list,id);
    }
}
