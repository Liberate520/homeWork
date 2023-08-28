package src.presenter;

import src.model.*;
import src.view.View;
import java.io.IOException;

import src.model.Service;
import src.view.ConsoleUI;
import src.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {
    private View view;
//    private HumanTree<Human> humansTreeConnect;
    private ObjIO serialize;

    private HumanComparatorByAge sortAge;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public Presenter(View view, HumanTree<Human> familyConnect, ObjIO serialize, HumanComparatorByAge sortAge) {
//        this.humansTreeConnect = familyConnect;
        this.view = view;
        this.service = new Service(familyConnect);
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHuman(String name, Gender aSex, LocalDate aBD) {  // String name, String sex, int age
        service.addHuman(name, aSex, aBD);
    }

    public void addChild(String nameParent, LocalDate bdParent,
                         String nameChild, LocalDate bdChild) {
        if (!nameParent.equalsIgnoreCase(nameChild)   // names not equal
                && ! bdParent.toString().equals(bdChild.toString())){  // birthDays not equal
            view.printAnswer(service.addChild( nameParent,  bdParent,
                     nameChild, bdChild));
        } else {
            view.printAnswer("Ошибка: Имя (или день Рождения) Родителя и Ребенка совпадают...");
        }
    }

    public void getHumansInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        view.printAnswer(service.getTreeInfo());
    }

    public void sortByName() {
        service.sortByName();
        view.printAnswer(service.getTreeInfo());
    }

    public void  LoadHumansFromFile(String fileName) {
        view.printAnswer("LoadHumansFromFile...");
        service.loadFromFile(fileName);
    }

    public void  SaveHumansToFile(String fileName)   {   // throws IOException, ClassNotFoundException
        view.printAnswer("SaveHumansToFile...");
        service.saveToFile(fileName);
    }

    public void humanSearch(String name) {
        view.printAnswer(service.humanSearch(name));
    }

    public void humanSearchFamily(String name) {
        Human human = service.getByName(name);
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
