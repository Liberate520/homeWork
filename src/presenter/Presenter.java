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

    public void addChild(String nameParent, LocalDate bdParent,
                         String nameChild, LocalDate bdChild) {
        if (!nameParent.equalsIgnoreCase(nameChild)   // names not equal
                && ! bdParent.toString().equals(bdChild.toString())){  // birthDays not equal
            // Find parent   nameParent,  bdParent
            Human aParent = humanFind(nameParent, bdParent);

            // find child   nameChild, bdChild
            Human aChild = humanFind(nameChild, bdChild);

            // add child to parent
            aParent.addChild(aChild);
            view.printAnswer(aParent.getChilds());
        } else {
            view.printAnswer("Ошибка: Имя (или день Рождения) Родителя и Ребенка совпадают...");
        }

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

    public Human humanFind(String name, LocalDate bd) {
        Human human = humansTreeConnect.getByNameDay (name, bd);
        return human;
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
