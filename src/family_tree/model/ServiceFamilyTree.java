package family_tree.model;

import family_tree.model.human.Human;
import family_tree.model.marriage.Marriage;
import saveload.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class ServiceFamilyTree {
    private int idMarriage, idHuman;
    private FamilyTree<Human> tree;
    public ServiceFamilyTree(){
        tree = new FamilyTree();
    }

    public Human addItem(String name, LocalDate dateBirth, Gender gender){
        Human h = new Human(idHuman++, name, dateBirth, gender);
        tree.addItem(h);
        return h;
    }
    public void addItem(Human t){
        tree.addItem(t);
    }

    //регистрируем брак и возвращаем ссылку на экземпляр
    //Если нарушены условия, return null
    public Marriage addMarriage(LocalDate startDate, Human wife, Human husband){
        Marriage m = new Marriage(idMarriage, startDate, wife, husband);
        if(m.getIsError()) return null;
        tree.addMarriage(m);
        idMarriage++;
        return m;
    }
    public boolean addMarriage(LocalDate startDate, int idWife, int idHusband){
        Human wife = getItemById(idWife);
        if (wife==null) return false;
        Human husband = getItemById(idHusband);
        if (husband==null) return false;

        Marriage m = new Marriage(idMarriage, startDate, wife, husband);
        if(m.getIsError()) return false;
        tree.addMarriage(m);
        idMarriage++;
        return true;
    }

    // добавляем связь родитель - потомок
    public boolean addChild(Human parent, Human child) {
        return parent.addChild(child);
    }
    public boolean addChild(int idParent, int idChild){
        Human parent = getItemById(idParent);
        if(parent==null) return false;
        Human child = getItemById(idChild);
        if(child==null) return false;
        return parent.addChild(child);
    }

    //return null, если список пуст либо id вне имеющихся
    public Human getItemById(int id){
        return tree.getItemById(id);
    }

    //return null, если список пуст либо id вне имеющихся
    public Marriage getMarriageById(int id){
        return tree.getMarriageById(id);
    }

    public boolean stopMarriageById(int id, LocalDate date){
        Marriage m = tree.getMarriageById(id);
        if(m == null) return false;
        return m.stop(date);
    }

    public String getHumansInfo(){
        return tree.getItemsInfo();
    }
    public String getMarriagesInfo(){
        return tree.getMarriagesInfo();
    }

    public void sortItemsByName(){
        tree.sortItemsByName();
    }
    public void sortItemsByAge(){
        tree.sortItemsByAge();
    }

    public String getInfoAll(){
        return tree.getInfoAll();
    }

    public FamilyTree getTree(){
        return tree;
    }

    public String getInfoLastItem() {
        return tree.getInfoLastItem();
    }
    public String getInfoLastMarriage() {
        return tree.getInfoLastMarriage();
    }

    //Выполняем запись содержимого дерева в файл
    public boolean saveToFile(String path) {
        FileHandler filehandler = new FileHandler();
        try {
            filehandler.saveTo(tree, path);
        }
        catch(IOException e) {
            return false;   //System.out.println(e.toString());
        }
        return true;
    }
    //Выполняем чтение содержимого дерева из файла
    public boolean loadFromFile(String path) {
        FileHandler filehandler = new FileHandler();
        try {
            tree = (FamilyTree)filehandler.loadFrom(path);
        }
        catch(IOException e) {
            return false;
        }
        catch(ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
