package family_tree.model;

import family_tree.model.group.Group;
import family_tree.model.group.GroupItemFamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.InformerHuman;
import family_tree.model.marriage.InformerMarriage;
import family_tree.model.marriage.Marriage;
import saveload.LoadFrom;
import saveload.SaveTo;

import java.io.IOException;
import java.time.LocalDate;

public class ServiceFamilyTree {
    private int idMarriage, idHuman;
    private FamilyTree<Human> tree;
    private SaveTo saver;
    private LoadFrom loader;
    private InformerHuman informerHuman;
    private InformerMarriage informerMarriage;

    public ServiceFamilyTree(SaveTo saver, LoadFrom loader){
        GroupItemFamilyTree<Human> humans = new GroupItemFamilyTree<>();
        Group<Marriage<Human>> marriages = new Group<>();
        tree = new FamilyTree(humans, marriages);
        this.saver = saver;
        this.loader = loader;
        informerHuman = new InformerHuman();
    }

    public void addItem(String name, LocalDate dateBirth, Gender gender){
        //Объекты Human можем создавать только в сервисе
        tree.addItem(new Human(idHuman++, name, dateBirth, gender, informerHuman));
    }

    //регистрируем брак
    public boolean addMarriage(LocalDate startDate, int idWife, int idHusband){
        Human wife = getItemById(idWife);
        if (wife==null) return false;
        Human husband = getItemById(idHusband);
        if (husband==null) return false;

        //Объекты Marriage<Human> можем создавать только в сервисе
        Marriage<Human> m = new Marriage<>(idMarriage, startDate, wife, husband, informerMarriage);
        if(m.getIsError()) return false;
        tree.addMarriage(m);
        idMarriage++;
        return true;
    }

    // добавляем связь родитель - потомок
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

    public boolean stopMarriageById(int id, LocalDate date){
        Marriage m = tree.getMarriageById(id);
        if(m == null) return false;
        return m.stop(date);
    }

    public String getInfoHumans(){
        return tree.getItemsInfo();
    }
    public String getInfoMarriages(){
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

    public String getInfoLastItem() {
        return tree.getInfoLastItem();
    }
    public String getInfoLastMarriage() {
        return tree.getInfoLastMarriage();
    }

    //Выполняем запись содержимого дерева
    public boolean saveTo(String path) {
        try {
            saver.saveTo(tree, path);
        }
        catch(IOException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
    //Выполняем чтение содержимого дерева
    public boolean loadFrom(String path) {
        try {
            tree = (FamilyTree)loader.loadFrom(path);
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
