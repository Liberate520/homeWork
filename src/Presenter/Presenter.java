package Presenter;
import Model.BaseCharacter.BaseCharacter;
import Model.BaseCharacter.Gender;
import Model.BaseCharacter.Human;
import Model.Service.Service;
import View.Viewable;

import java.io.Serializable;

public class Presenter implements Serializable {
    private Viewable view;
    private Service<BaseCharacter> service;

    public Presenter(Viewable view) {
        service = new Service<>();
    }
    public void addBaseCharacter(String name, int age, Gender gender){
        service.add(name, age, gender);
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
