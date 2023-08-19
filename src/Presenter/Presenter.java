package Presenter;
import Model.*;
import View.Viewable;

import java.io.Serializable;

public class Presenter implements Serializable {
    private Viewable view;
    private Service<HouseHold> service;

    public Presenter(Viewable view) {
        this.view = view;
        service = new Service<>();
    }
    public void addHouseHold(HouseHold houseHold){
        service.add(houseHold);
    }

    public void getListInfo(){
        service.printTree();
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }

    public void saveToFile(){
        service.saveTree(service.getFamilyTree(), "src/Data/text.txt");
    }

    public void readFile(String filePath) {
        service.readTree(filePath);
    }
}
