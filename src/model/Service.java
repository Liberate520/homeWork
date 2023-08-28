package src.model;

import src.model.HumanTree;
import src.model.Human;

import java.io.IOException;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

public class Service {

    private HumanTree humanTree;
    private String fileName;

    public Service() {
        humanTree = new HumanTree();
    }

    public Service(HumanTree<Human> familyConnect) {
        humanTree = familyConnect;
    }

    public void addHuman(String aName, Gender aSex, LocalDate aBirthDay){
        Human aHuman = new Human(aName, aSex, aBirthDay);
        humanTree.addHuman(aHuman);

    }

    public String addChild(String nameParent, LocalDate bdParent,
                         String nameChild, LocalDate bdChild) {
        if (!nameParent.equalsIgnoreCase(nameChild)   // names not equal
                && ! bdParent.toString().equals(bdChild.toString())){  // birthDays not equal
            // Find parent   nameParent,  bdParent
            Human aParent = humanFind(nameParent, bdParent);

            // find child   nameChild, bdChild
            Human aChild = humanFind(nameChild, bdChild);

            // add child to parent
            aParent.addChild(aChild);
            return aParent.getChilds();
        } else {
            return "Ошибка: Имя (или день Рождения) Родителя и Ребенка совпадают...";
        }
    }

    public Human humanFind(String name, LocalDate bd) {
        Human human = humanTree.getByNameDay (name, bd);  ///  (String name, LocalDate bd)
        return human;
    }

    public  String loadFromFile(String fileName) {
        HumanTree aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT = (HumanTree) aIO.readFile(fileName);

        humanTree = aHT;
        humanTree.setFileName(fileName);
        return "HumanTree load from " + fileName;
    }

    public  String addFromFile(String fileName)  throws IOException, ClassNotFoundException    {
        HumanTree aHT;
        // Востановление из файла с помощью класса ObjectInputStream
        ObjIO aIO = new ObjIO();
        aHT =  (HumanTree) aIO.readFile(fileName);   //

        humanTree.addHumanTree(aHT.getHumans());
        humanTree.setFileName(fileName);
        return "HumanTree add from " + fileName;
    }

    public  String  saveToFile(String fileName) {
//        humanTree.saveToFile(fileName);
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjIO aIO = new ObjIO();
        aIO.writeFile(fileName, (Serializable) humanTree);

        humanTree.setFileName(fileName);
        return "HumanTree save to " + fileName;
    }

    public String humanSearch(String name) {
        Human human = humanTree.getByName(name);
        if (human == null)
            return "Такого человека нет в семье !";
        else {
            return human.toString();
        }
    }


    public  Human getByNameDay(String name, LocalDate bd){
        return humanTree.getByNameDay (name, bd);
    }

    public  Human  getByName(String name) {
        return humanTree.getByName (name);
    }

    public String getTreeInfo() {
        return humanTree.toString();
    }
    public void sortByName(){
        humanTree.sortByName();
    }

    public void sortByAge(){
        humanTree.sortByAge();
    }
}
