package src.presenter;

import src.model.*;
import src.view.View;
import java.io.IOException;

//import src.model.service.Service;
import src.view.ConsoleUI;
import src.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {
    private View view;
    private HumanTree<Human> humansTreeConnect;
    private ObjIO serialize;

    private HumanComparatorByAge sortAge;

//    private Service service;

    public Presenter(View view) {
        this.view = view;
//        service = new Service();
    }

    public Presenter(View view, HumanTree<Human> familyConnect, ObjIO serialize, HumanComparatorByAge sortAge) {
        this.humansTreeConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHuman(String name, Gender aSex, LocalDate aBD) {  // String name, String sex, int age
        // humansTreeConnect.addHuman(new Human(name, sex, age));
        humansTreeConnect.addHuman(new Human(name, aSex, aBD));
    }

    public void addChild(String name, int age) {
        // Find parent

        // find child

        // add child to parent
//        service.addStudent(name, age);
//        //какой-то ответ
//        getStudentsListInfo();
    }

    public void getHumansInfo() {
        String info = humansTreeConnect.toString();
        view.printAnswer(info);
    }

    public void sortByAge() {
        humansTreeConnect.sortByAge();
        view.printAnswer(humansTreeConnect.toString());
    }

    public void sortByName() {
        humansTreeConnect.sortByName();
        view.printAnswer(humansTreeConnect.toString());
    }

    public void  LoadHumansFromFile(String fileName) {
        view.printAnswer("LoadHumansFromFile...");
        humansTreeConnect.loadFromFile(fileName);
    }

    public void  SaveHumansToFile(String fileName)   {   // throws IOException, ClassNotFoundException
        view.printAnswer("SaveHumansToFile...");
        humansTreeConnect.saveToFile(fileName);
    }

    public void humanSearch(String name) {
        Human human = humansTreeConnect.getByName(name);
        if (human == null)
            view.printAnswer("Такого человека нет в семье !");
        else {
            String foundHuman = human.toString();
            view.printAnswer(foundHuman);
        }
    }

    public void humanSearchFamily(String name) {
        Human human = humansTreeConnect.getByName(name);
        if (human == null)
            view.printAnswer("Такого человека нет в семье !");
        else {
            // get full family
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(human.toString());
            stringBuilder.append(human.getGrandParentsStr());
            stringBuilder.append(human.getParentsStr());
            stringBuilder.append(human.getBrotherSisterStr());
            stringBuilder.append(human.getChilds());

            view.printAnswer(stringBuilder.toString());
        }
    }


}
